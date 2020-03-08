package org.example.models;

import org.example.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
With @Component annotation, Spring associates the TennisCoach class with the default bean id "tennisCoach".
We can define a custom bean id by @Component("justATennisCoach")
 */
@Component
//@Scope("prototype")       // defining different scope for bean
public class TennisCoach implements Coach {


    //@Autowired  // field dependency injection
    //@Qualifier("happyFortuneService")     // used because of multiple implementations of FortuneService interface
    private FortuneService fortuneService;

    @Value("${team}")   // value injection through .properties file - no need for setter method
    private String team;


    @Autowired  // constructor dependency injection - preferred for mandatory fields
    // https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-setter-injection
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    /*
    @Autowired  // setter dependency injection
    public void setFortuneService(@Qualifier("databaseFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    */

    @PostConstruct  // init method
    public void init() {
        System.out.println("Doing initialization of bean...");
    }

    @PreDestroy     // destruoy method
    public void doCleanUp() {
        System.out.println("Doing some clean up stuff...");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }


    public String getTeam() {
        return team;
    }
}
