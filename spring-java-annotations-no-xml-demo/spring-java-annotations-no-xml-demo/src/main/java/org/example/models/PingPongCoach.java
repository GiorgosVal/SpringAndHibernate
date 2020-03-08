package org.example.models;

import org.example.services.FortuneService;
import org.springframework.stereotype.Component;

/*
With @Component annotation, Spring associates the PingPongCoach class with the default bean id "pingPongCoach".
We can define a custom bean id by @Component("customPingPongCoach")
 */
@Component
public class PingPongCoach implements Coach {

    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Practice your service skills with an egg.";
    }

    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}
