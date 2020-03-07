package org.example;

import org.example.models.BaseballCoach;
import org.example.models.Coach;
import org.example.models.TrackCoach;
import org.example.services.HappyFortuneService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Coach coach = new BaseballCoach(new HappyFortuneService());
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        coach = new TrackCoach(new HappyFortuneService());
        System.out.println(coach.getDailyWorkout());


    }
}
