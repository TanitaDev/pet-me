package com.tanita.dateme.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface S3Service {
    void uploadFile(String keyName, MultipartFile file) throws IOException;

}
