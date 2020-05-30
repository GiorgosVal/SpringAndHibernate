package org.example.springbootwiththymeleaf.ThymeleafDemoWithSpringBoot.controllers;

import org.example.springbootwiththymeleaf.ThymeleafDemoWithSpringBoot.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employees;

    @PostConstruct
    private void loadMockData() {
        employees = new ArrayList<>();
        employees.add(new Employee(1, "Leslie", "Andrews", "leslie@gmail.com"));
        employees.add(new Employee(1, "Ema", "Baumgarten", "ema@gmail.com"));
        employees.add(new Employee(1, "Avani", "Gupta", "avani@gmail.com"));
        employees.add(new Employee(1, "Jon", "Doe", "jon@gmail.com"));
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employees);
        return "list-employees";
    }
}
