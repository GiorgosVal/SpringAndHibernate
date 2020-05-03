package org.example.springrestdemo.mvc.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String s) {
        super(s);
    }

    public InvalidCredentialsException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidCredentialsException(Throwable throwable) {
        super(throwable);
    }
}
