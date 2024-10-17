package com.tanita.dateme.dto;

import lombok.Data;


public record InMemoryFile(String fileName, String contentType, byte[] content) {

}
