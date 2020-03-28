package org.example;

import org.example.models.Course;
import org.example.models.Instructor;
import org.example.models.InstructorDetail;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetInstructorAndCoursesDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 1);
            System.out.println("Instructor retrieved: " + instructor);
            List<Course> courses = instructor.getCourses();

            if(courses.isEmpty()) {
                System.out.println("Instructor has no courses.");
            } else {
                System.out.println("Instructor has the following courses:");
                for(Course course : courses) {
                    System.out.println(course);
                }
            }

            session.getTransaction().commit();

        } catch (HibernateException e) {

        } finally {
            session.close();
        }




    }
}
