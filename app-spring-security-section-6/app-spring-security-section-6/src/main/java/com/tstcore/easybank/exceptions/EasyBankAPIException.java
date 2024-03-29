package com.tstcore.easybank.exceptions;

import org.springframework.http.HttpStatus;

public class EasyBankAPIException extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public EasyBankAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
