package com.tanita.petme.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.tanita.petme.config.awc.InMemoryFile;
import com.tanita.petme.service.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultS3Service implements S3Service {

    @Value("${storage.s3.bucket}")
    private String bucketName;

    private final AmazonS3 s3Client;

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        File fileObj = convertMultiPartFileToFile(file);
        String fileKey = UUID.randomUUID() + "-" + System.currentTimeMillis();
        s3Client.putObject(new PutObjectRequest(bucketName, fileKey, fileObj));
        fileObj.delete();
        return "File uploaded: " + fileKey;
    }


//    @Override
//    public String uploadFile(MultipartFile file) throws IOException {
//        File fileObj = convertMultiPartFileToFile(file);
//        String fileKey = UUID.randomUUID() + "-" + System.currentTimeMillis();
//        ObjectMetadata metadata = new ObjectMetadata();
//        metadata.setContentType(file.getContentType());
//        byte[] fileObj1 = Files.readAllBytes(fileObj.toPath());
//        metadata.setContentLength(fileObj1.length);
//
//        Path tempFile =  Files.createTempFile("temp", fileKey);
//        File file1 = tempFile.toFile();
//        file.transferTo(file1);
////        s3Client.putObject(new PutObjectRequest(bucketName, fileKey, fileObj));
//        s3Client.putObject(new PutObjectRequest(bucketName, fileKey, new ByteArrayInputStream(fileObj1), metadata));
//
//        //s3Client.putObject(bucketName, fileKey, fileObj);
//        fileObj.delete();
//        return "File uploaded: " + fileKey;
//    }

    @Override
    public InMemoryFile downloadFile(String fileName) {
        S3Object s3Object = s3Client.getObject(bucketName, fileName);
        String contentType = s3Object.getObjectMetadata().getContentType();
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            return new InMemoryFile(fileName, contentType, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteFile(String fileName) {
        s3Client.deleteObject(bucketName, fileName);
        return fileName + " removed ...";
    }

    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }
}
