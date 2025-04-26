package com.tanita.petme.api;

import com.tanita.petme.config.awc.InMemoryFile;
import com.tanita.petme.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController()
@RequiredArgsConstructor
@RequestMapping("/api/aws")
public class S3Controller {

    private final S3Service s3Service;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        s3Service.uploadFile(file);
        return ResponseEntity.ok("Uploaded");
    }

    @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam String fileName) {
        InMemoryFile file = s3Service.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(file.content());
        return ResponseEntity
                .ok()
                .contentLength(file.content().length)
                .header("Content-type", file.contentType())
                .header("Content-disposition", "attachment; filename=\"" + file.fileName() + "\"")
                .body(resource);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteFile(@RequestParam String fileName) {
        s3Service.deleteFile(fileName);
        return ResponseEntity.ok("Deleted");
    }
}
