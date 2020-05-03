package org.example.springrestdemo.mvc.exceptions;

import org.example.springrestdemo.mvc.responses.BadRequestApiResponse;
import org.example.springrestdemo.mvc.responses.ApiResponse;
import org.example.springrestdemo.mvc.responses.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        // body of the response
        StudentErrorResponse response = new StudentErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        response.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);    // body, status code
    }

    @ExceptionHandler
    public ResponseEntity<ApiResponse> handleException(MethodArgumentTypeMismatchException exception) {
        // body of the response
        ApiResponse response = new ApiResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(exception.getMessage());
        response.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);    // body, status code
    }

    @ExceptionHandler
    public ResponseEntity<ApiResponse> handleException(NotFoundException exception) {
        // body of the response
        ApiResponse response = new ApiResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        response.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);    // body, status code
    }

    @ExceptionHandler
    public ResponseEntity<ApiResponse> handleException(BadRequestException exception) {
        // body of the response
        BadRequestApiResponse response = new BadRequestApiResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(exception.getMessage());
        response.setTimestamp(System.currentTimeMillis());
        response.setSuggestion(exception.getSuggestion());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);    // body, status code
    }


}
