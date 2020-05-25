package org.example.springboot.demo.MyFirstSpringBootDemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {


    @Value("${custom.prop.name}")
    private String name;

    @Value("${custom.prop.height}")
    private String height;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World! Time on server is " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    @GetMapping("/athleteInfo")
    public String getAthletesInfo(){
        return "Athlete: " + name + ", height: " + height + "cm.";
    }


}
