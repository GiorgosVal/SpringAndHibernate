package org.example.springrestdemo.mvc.exceptions;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public StudentNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
