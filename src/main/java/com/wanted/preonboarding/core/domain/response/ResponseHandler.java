package com.wanted.preonboarding.core.domain.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
public record ResponseHandler<T>(HttpStatus statusCode, String message, T data) {

    public static <T> ResponseHandler<T> success(HttpStatus statusCode, String message, T data) {
        return ResponseHandler.<T>builder()
                .statusCode(statusCode)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ResponseHandler<T> error(HttpStatus statusCode, String message) {
        return ResponseHandler.<T>builder()
                .statusCode(statusCode)
                .message(message)
                .data(null)
                .build();
    }
}
