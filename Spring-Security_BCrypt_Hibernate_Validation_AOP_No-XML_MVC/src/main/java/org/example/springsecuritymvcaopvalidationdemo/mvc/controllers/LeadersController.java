package org.example.springsecuritymvcaopvalidationdemo.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/leaders")
public class LeadersController {

    @GetMapping
    public String showLeaders() {
        return "leaders-home";
    }

}
