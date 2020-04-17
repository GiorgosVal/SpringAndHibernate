package org.example.springsecuritydemo.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DemoController {

    @GetMapping("/")
    public String showHome() {
        return "landing-page";
    }

    @GetMapping("/employees")
    public String showEmployees() {
        return "employees-home";
    }

    @GetMapping("/leaders")
    public String showLeeders() {
        return "leaders-home";
    }

    @GetMapping("/systems")
    public String showSystems() {
        return "systems-home";
    }

    @GetMapping("/forbidden")
    public String showAccessDenied() {
        return "access-denied";
    }

}
