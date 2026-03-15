package org.microservice.orderservice.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalHandlerException {

    private ApiError buildApiError(String message, String path, int status, List<ValidationError> errors){
        return new ApiError(
                message,
                path,
                status,
                errors
        );
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiError> handleBusinessException(BusinessException ex, HttpServletRequest request){
        return ResponseEntity
                .status(ex.getErrorCode().getStatus())
                .body(buildApiError(
                        ex.getMessage(),
                        request.getRequestURI(),
                        ex.getErrorCode().getStatus().value(),
                        null
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationError(MethodArgumentNotValidException ex, HttpServletRequest request){
        List<ValidationError> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> new ValidationError(error.getField(), error.getDefaultMessage()))
                .toList();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(buildApiError(
                        ex.getMessage(),
                        request.getRequestURI(),
                        HttpStatus.NO_CONTENT.value(),
                        errors
                ));
    }
}