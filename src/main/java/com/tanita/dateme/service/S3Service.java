package com.tanita.dateme.service;

import com.tanita.dateme.config.awc.InMemoryFile;
import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
    String uploadFile(MultipartFile file);

    InMemoryFile downloadFile(String fileName);

    String deleteFile(String fileName);

}
