package org.example.springmvcdemo.controllers;

import org.example.springmvcdemo.models.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{carsOptions}")
    private Map<String, String> carOptions;

    private List<String> foodOptions;

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("carsOptions", carOptions);
        model.addAttribute("foodOptions", getFoodOptions());
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.println(student.getName() + " " + student.getLastName());
        return "student-confirmation";
    }

    private List<String> getFoodOptions(){
        foodOptions = new ArrayList<>();
        foodOptions.add("Pasta");
        foodOptions.add("Salad");
        foodOptions.add("Burger");
        return foodOptions;
    }




}
