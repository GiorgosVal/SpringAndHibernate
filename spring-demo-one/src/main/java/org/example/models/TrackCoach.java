package org.example.models;

import org.example.services.FortuneService;

public class TrackCoach implements Coach{

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k.";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it: " + this.fortuneService.getFortune();
    }

    private void initialize() {
        System.out.println("initializing TrackCoach...");
    }

    private void destroy() {
        System.out.println("clean up stuff for TrackCoach...");
    }
}
