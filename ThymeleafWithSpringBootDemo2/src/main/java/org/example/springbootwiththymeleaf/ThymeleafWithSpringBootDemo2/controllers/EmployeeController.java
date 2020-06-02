package org.example.springbootwiththymeleaf.ThymeleafWithSpringBootDemo2.controllers;

import org.example.springbootwiththymeleaf.ThymeleafWithSpringBootDemo2.models.Employee;
import org.example.springbootwiththymeleaf.ThymeleafWithSpringBootDemo2.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.isNull;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> mockEmployeeList;
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private List<Employee> createMockEmployeeList() {
        mockEmployeeList = new ArrayList<>();
        mockEmployeeList.add(new Employee(1, "Leslie", "Andrews", "leslie@gmail.com"));
        mockEmployeeList.add(new Employee(1, "Ema", "Baumgarten", "ema@gmail.com"));
        mockEmployeeList.add(new Employee(1, "Avani", "Gupta", "avani@gmail.com"));
        mockEmployeeList.add(new Employee(1, "Jon", "Doe", "jon@gmail.com"));
        return mockEmployeeList;
    }

    private Employee createMockEmployee() {
        return new Employee("John", "Doe", "john@doe.com");
    }

    @GetMapping("/list")
    public String listEmployees(@RequestParam(value = "mock", required = false) boolean wantMock,
                                @RequestParam(value = "by", required = false) String orderBy,
                                @RequestParam(value = "order", required = false) String order,
                                Model model) {

        boolean orderByLastNameAsc = !isNull(orderBy) && orderBy.toLowerCase().equals("lastname") && !isNull(order) && order.toLowerCase().equals("asc");
        boolean orderByLastNameDesc = !isNull(orderBy) && orderBy.toLowerCase().equals("lastname") && !isNull(order) && order.toLowerCase().equals("desc");

        if(!wantMock) {
            if (orderByLastNameAsc) {
                model.addAttribute("employees", employeeService.findAllOrderByLastNameAsc());
            } else if (orderByLastNameDesc) {
                model.addAttribute("employees", employeeService.findAllOrderByLastNameDesc());
            } else {
                model.addAttribute("employees", employeeService.findAll());
            }
        } else {
            model.addAttribute("employees", createMockEmployeeList());
        }
        return "list-employees";
    }

    @GetMapping("/add-employee")
    public String addEmployee(@RequestParam(value = "mock", required = false) boolean wantMock,
                              Model model) {
        if (!wantMock) {
            model.addAttribute("employee", new Employee());
        } else {
            model.addAttribute("employee", createMockEmployee());
        }
        return "add-or-update-employee-form";
    }

    @PostMapping("/save-employee")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam(value = "id") int id,
                                 Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "add-or-update-employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam(value = "id") int id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }


}
