/**
 * @author Xiaohan Chen
 */
package com.example.pfm.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends IllegalArgumentException{

    private final String id;

    public NotFoundException(String id) {
        super(id +  " not found.");
        this.id = id;
    }
}






