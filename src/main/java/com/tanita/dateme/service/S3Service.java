package com.tanita.dateme.service;

import com.tanita.dateme.dto.InMemoryFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface S3Service {
    String uploadFile(MultipartFile file);

    InMemoryFile downloadFile(String fileName);

    String deleteFile(String fileName);

}
