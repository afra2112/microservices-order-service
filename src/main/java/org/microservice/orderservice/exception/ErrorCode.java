package org.microservice.orderservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    //ORDERS
    ORD_001("CANNOT_CREATE_ORDER", "Some problem creating order.", HttpStatus.INTERNAL_SERVER_ERROR),
    //GENERIC
    GNR_001("ENTITY_NOT_FOUND", "Entity not found", HttpStatus.NOT_FOUND);

    private String code;
    private String message;
    private HttpStatus status;

    ErrorCode(String code, String message, HttpStatus status){
        this.message = message;
        this.status = status;
    }
}
