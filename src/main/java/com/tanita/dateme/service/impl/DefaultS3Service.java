package com.tanita.dateme.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.tanita.dateme.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DefaultS3Service implements S3Service {
    private final AmazonS3 s3client;

    @Value("${storage.s3.bucket}")
    private String bucketName;


    @Override
    public void uploadFile(String keyName, MultipartFile file) throws IOException {
        s3client.putObject(bucketName, keyName, file.getInputStream(), null);
    }

    public S3Object getFile(String keyName) {
        return s3client.getObject(bucketName, keyName);
    }


}
