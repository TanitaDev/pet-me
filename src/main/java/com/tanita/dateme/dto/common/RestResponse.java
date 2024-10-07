package com.tanita.dateme.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponse<T> {

    @JsonProperty("data")
    private T body;
    private RestErrorData errorData;
    private RestResponseStatus status;

    public static <T> RestResponse<T> ok() {
        RestResponse<T> response = new RestResponse<>();
        response.setStatus(RestResponseStatus.ok());
        return response;
    }

    public static <T> RestResponse<T> ok(T data) {
        RestResponse<T> response = new RestResponse<>();
        response.setBody(data);
        response.setStatus(RestResponseStatus.ok());
        return response;
    }

    public static <T> RestResponse<T> error(int code, String message) {
        RestResponse<T> response = new RestResponse<>();
        response.setStatus(new RestResponseStatus(code, message));
        return response;
    }

}
