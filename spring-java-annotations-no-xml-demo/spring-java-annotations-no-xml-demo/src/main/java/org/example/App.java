package org.example;

import org.example.config.AppConfig;
import org.example.models.Coach;
import org.example.models.SwimCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Coach coach = context.getBean("tennisCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());

        SwimCoach swimCoach1 = context.getBean("swimCoach", SwimCoach.class);
        SwimCoach swimCoach2 = context.getBean("swimCoach", SwimCoach.class);
        System.out.println(swimCoach1.getDailyWorkout());
        System.out.println(swimCoach1.getDailyFortune());
        System.out.println(swimCoach1.getEmail());
        System.out.println(swimCoach1.getTeam());

        printEquality(swimCoach1, swimCoach2);

        swimCoach1 = context.getBean("swimCoachPrototype", SwimCoach.class);
        swimCoach2 = context.getBean("swimCoachPrototype", SwimCoach.class);
        printEquality(swimCoach1, swimCoach2);

    }

    private static void printEquality(Coach coach1, Coach coach2) {
        String result = (coach1 == coach2) ? "is" : "is not";

        System.out.println("coach1 " + result + " equal to coach2.");
        System.out.println("Memory location of coach1: " + coach1);
        System.out.println("Memory location of coach2: " + coach2);
    }
}
