package org.example.models;

import org.example.services.thirdparty.ThirdPartyFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class SwimCoach implements Coach {

    private ThirdPartyFortuneService fortuneService;

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @Value("${email}")
    private String email;

    @Value("${team}")
    private String team;


    //@Autowired
    public SwimCoach(ThirdPartyFortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up.";
    }

    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }


}
