package com.tanita.petme.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestResponseStatus <T> {

    private int code;
    private String message;

    public static RestResponseStatus ok() {
        return new RestResponseStatus(0, HttpStatus.OK.getReasonPhrase());
    }

}
