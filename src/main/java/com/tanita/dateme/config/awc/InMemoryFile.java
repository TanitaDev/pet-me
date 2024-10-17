package com.tanita.dateme.config.awc;

import lombok.Data;


public record InMemoryFile(String fileName, String contentType, byte[] content) {

}
