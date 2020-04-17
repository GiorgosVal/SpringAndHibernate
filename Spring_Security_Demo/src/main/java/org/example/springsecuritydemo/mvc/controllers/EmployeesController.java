package org.example.springsecuritydemo.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

    @GetMapping
    public String showEmployees2() {
        return "employees-home";
    }
}
