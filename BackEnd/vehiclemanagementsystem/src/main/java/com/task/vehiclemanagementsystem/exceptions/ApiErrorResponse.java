package com.task.vehiclemanagementsystem.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiErrorResponse extends RuntimeException {
    private final LocalDateTime timestamp;
    private final HttpStatus status;

    public ApiErrorResponse(String message, HttpStatus status) {
        super(message);
        this.timestamp = LocalDateTime.now();
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
