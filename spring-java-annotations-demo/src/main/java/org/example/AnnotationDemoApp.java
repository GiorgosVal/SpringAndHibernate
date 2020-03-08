package org.example;

import org.example.models.Coach;
import org.example.models.TennisCoach;
import org.example.services.FileFortuneService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AnnotationDemoApp
{
    public static void main( String[] args )
    {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/config/applicationContext.xml");

        Coach coach = context.getBean("tennisCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        coach = context.getBean("pingPongCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());

        TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        System.out.println(tennisCoach.getTeam());

        FileFortuneService fileFortuneService = context.getBean("fileFortuneService", FileFortuneService.class);
        System.out.println(fileFortuneService.getFortune());
        System.out.println(fileFortuneService.getFortune());
        System.out.println(fileFortuneService.getFortune());
        System.out.println(fileFortuneService.getFortune());
        System.out.println(fileFortuneService.getFortune());
    }
}
