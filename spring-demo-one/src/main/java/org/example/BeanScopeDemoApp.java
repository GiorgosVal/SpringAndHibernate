package org.example;

import org.example.models.Coach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {
        ApplicationContext contextPrototype = new FileSystemXmlApplicationContext("src/config/bean-scopes-appContext.xml");
        ApplicationContext contextSingleton = new FileSystemXmlApplicationContext("src/config/applicationContext.xml");

        Coach coach1 = contextPrototype.getBean("myCoach", Coach.class);
        Coach coach2 = contextPrototype.getBean("myCoach", Coach.class);

        printEquality(coach1, coach2);

        coach1 = contextSingleton.getBean("myCoach", Coach.class);
        coach2 = contextSingleton.getBean("myCoach", Coach.class);

        printEquality(coach1, coach2);

    }

    private static void printEquality(Coach coach1, Coach coach2) {
        String result = (coach1 == coach2) ? "is" : "is not";
        System.out.println("coach1 " + result + " equal to coach2");
        System.out.println("Memory location of coach1: " + coach1);
        System.out.println("Memory location of coach2: " + coach2);
    }
}
