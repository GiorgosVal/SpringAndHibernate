package org.example.springsecuritymvcaopvalidationdemo.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {

    @GetMapping
    public String showHome() {
        return "landing-page";
    }

    @GetMapping("login-page")
    public String showLoginForm() {
        return "login-form";
    }

    @GetMapping("access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }


}
