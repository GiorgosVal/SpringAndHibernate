package org.example;

import org.example.models.Course;
import org.example.models.Instructor;
import org.example.models.InstructorDetail;
import org.example.models.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {

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

            Course course = new Course("Pacman - How To Score One Million Points");

            course.addReview(new Review("Great course... loved it!"));
            course.addReview(new Review("Cool course, job well done!"));
            course.addReview(new Review("What a dumb course, you are an idiot!"));

            session.persist(course);

            session.getTransaction().commit();
            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
