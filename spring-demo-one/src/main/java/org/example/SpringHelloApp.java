package org.example;

import org.example.models.Coach;
import org.example.models.CricketCoach;
import org.example.models.GolfCoach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringHelloApp {

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/config/applicationContext.xml");

        Coach coach = context.getBean("myCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
        System.out.println(cricketCoach.getDailyWorkout());
        System.out.println(cricketCoach.getDailyFortune());
        System.out.println(cricketCoach.getEmailAddress());
        System.out.println(cricketCoach.getTeam());
        System.out.println(cricketCoach.getName());
        System.out.println(cricketCoach.getAge());

        GolfCoach golfCoach = context.getBean("myGolfCoach", GolfCoach.class);
        System.out.println(golfCoach.getDailyWorkout());
        System.out.println(golfCoach.getDailyFortune());

    }
}
