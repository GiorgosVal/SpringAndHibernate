package org.example.springrestdemo.mvc.exceptions;

import lombok.Data;

@Data
public class BadRequestException extends RuntimeException {

    private Object suggestion;


    public BadRequestException(String s, Object suggestion) {
        super(s);
        this.suggestion = suggestion;
    }

    public BadRequestException(String s, Throwable throwable, Object suggestion) {
        super(s, throwable);
        this.suggestion = suggestion;
    }

    public BadRequestException(Throwable throwable, Object suggestion) {
        super(throwable);
        this.suggestion = suggestion;
    }
}
