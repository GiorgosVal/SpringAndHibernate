package org.example.springrestdemo.mvc.controllers.rest;

import org.example.springrestdemo.mvc.exceptions.InvalidCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/access-denied")
    public void accessDenied() {
        throw new InvalidCredentialsException("Invalid credentials. Unauthorized access.");
    }
}
