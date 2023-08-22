package com.tstcore.easybank.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class UserNotCreatedException extends RuntimeException {

    public UserNotCreatedException(){}
    public UserNotCreatedException(String message) {
        super(message);
    }
}
