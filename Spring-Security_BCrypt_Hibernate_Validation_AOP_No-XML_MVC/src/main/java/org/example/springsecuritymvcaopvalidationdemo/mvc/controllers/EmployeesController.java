package org.example.springsecuritymvcaopvalidationdemo.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stuff")
public class EmployeesController {

    @GetMapping
    public String showEmployees2() {
        return "employees-home";
    }
}
