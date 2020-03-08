package org.example.models;

import org.example.services.FortuneService;

public class FootballCoach implements Coach {

    private FortuneService fortuneService;

    public FootballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run around the stadium 10 times.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
