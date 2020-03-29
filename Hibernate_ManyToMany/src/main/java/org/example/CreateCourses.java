package org.example;

import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourses {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            String[] courseTitles = {
                    "Let's learn something not interesting at all.", "Mathematics", "Geography", "Physics",
                    "Python - The complete bootcamp for dumps", "Chess"
            };
            session.beginTransaction();

            for (String title : courseTitles) {
                session.persist(new Course(title));
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }



    }
}
