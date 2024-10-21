package com.tanita.dateme.service;

import com.tanita.dateme.config.awc.InMemoryFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface S3Service {
    String uploadFile(MultipartFile file) throws IOException;

    InMemoryFile downloadFile(String fileName);

    String deleteFile(String fileName);

}
