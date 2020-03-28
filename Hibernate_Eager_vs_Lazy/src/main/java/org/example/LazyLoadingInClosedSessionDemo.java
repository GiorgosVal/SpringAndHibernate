package org.example;

import org.example.models.Course;
import org.example.models.Instructor;
import org.example.models.InstructorDetail;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class LazyLoadingInClosedSessionDemo {

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
            System.out.println("Courses retrieved: " + courses); // FIRST REFERENCE
            session.getTransaction().commit();
            session.close();

            // session closed


            System.out.println(courses.isEmpty());  // SECOND REFERENCE
            if(courses.isEmpty()) {
                System.out.println("Instructor has no courses.");
            } else {
                System.out.println("Instructor has the following courses:");
                for(Course course : courses) {
                    System.out.println(course);
                }
            }



        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            //session.close();
        }




    }
}
