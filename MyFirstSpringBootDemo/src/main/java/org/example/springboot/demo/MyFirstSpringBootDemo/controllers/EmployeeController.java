package org.example.springboot.demo.MyFirstSpringBootDemo.controllers;

import org.example.springboot.demo.MyFirstSpringBootDemo.models.Employee;
import org.example.springboot.demo.MyFirstSpringBootDemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);

        if (Objects.isNull(employee)) {
            throw new RuntimeException("Employee id not found: " + id);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee add(@RequestBody Employee employee) {
        // set to 0 to force a save of new item instead of update
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String delete(@PathVariable int id) {
        Employee employee = employeeService.findById(id);

        if (Objects.isNull(employee)) {
            throw new RuntimeException("Employee id not found : " + id);
        }

        employeeService.deleteById(id);
        return "Deleted employee with id: " + id;
    }
}
