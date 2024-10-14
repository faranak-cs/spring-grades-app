package com.demo.grades.controller.handler;

import com.demo.grades.exception.StudentNotFoundException;
import com.demo.grades.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(final StudentNotFoundException ex) {
        final ErrorResponse errorResponse = buildErrorResponse(ex);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    private ErrorResponse buildErrorResponse(final StudentNotFoundException ex) {
        return ErrorResponse.builder()
            .message(ex.getMessage())
            .build();
    }

}
