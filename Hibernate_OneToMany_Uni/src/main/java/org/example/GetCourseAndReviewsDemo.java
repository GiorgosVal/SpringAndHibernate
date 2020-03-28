package org.example;

import org.example.models.Course;
import org.example.models.Instructor;
import org.example.models.InstructorDetail;
import org.example.models.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetCourseAndReviewsDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            Course course = session.get(Course.class, 10);
            System.out.println("Course retrieved: " + course);
            List<Review> reviews = course.getReviews();

            if(reviews.isEmpty()) {
                System.out.println("This course has no reviews.");
            } else {
                System.out.println("Reviews for the course:");
                for(Review review : reviews) {
                    System.out.println(review);
                }
            }


            session.getTransaction().commit();
            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
