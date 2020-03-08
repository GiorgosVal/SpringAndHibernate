package org.example;

import org.example.config.FootballConfig;
import org.example.models.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppWithNoComponentScan {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FootballConfig.class);

        Coach coach = context.getBean("footballCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

    }
}
