package org.example;

import org.example.models.Coach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {

        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/config/applicationContext.xml");

        Coach coach1 = context.getBean("tennisCoach", Coach.class);
        Coach coach2 = context.getBean("tennisCoach", Coach.class);

        printEquality(coach1, coach2);

        context.close();

    }

    private static  void printEquality(Coach coach1, Coach coach2) {
        String result = (coach1 == coach2) ? "is" : "is not";

        System.out.println("coach1 " + result + " equal to coach2.");
        System.out.println("Memory location of coach1: " + coach1);
        System.out.println("Memory location of coach2: " + coach2);
    }
}
