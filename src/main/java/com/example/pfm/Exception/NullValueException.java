/**
 * @author Xiaohan Chen
 */
package com.example.pfm.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NullValueException extends IllegalArgumentException{

    private final String id;

    public NullValueException(String id) {
        super(id +  " null value");
        this.id = id;
    }
}






