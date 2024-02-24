package com.tstcore.easybank.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private long longValue;
    private double doubleValue;
    private int intValue;
    private String stringValue;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        // custom message, i.e.: Account not found with id : 1
        super(String.format("%s resource with %s : '%s' not found", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.longValue = fieldValue;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        // custom message, i.e.: Account not found with id : 1
        super(String.format("%s resource with %s : '%s' not found", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.stringValue = fieldValue;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, double fieldValue) {
        // custom message, i.e.: Account not found with id : 1
        super(String.format("%s resource with %s : '%s' not found", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.doubleValue = fieldValue;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, int fieldValue) {
        // custom message, i.e.: Account not found with id : 1
        super(String.format("%s resource with %s : '%s' not found", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.intValue = fieldValue;
    }
}
