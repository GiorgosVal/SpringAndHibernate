package org.example;

import org.example.models.Course;
import org.example.models.Instructor;
import org.example.models.InstructorDetail;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Objects;

public class CreateCoursesDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Course course1 = new Course("Python fundamentals");
            Course course2 = new Course("Advanced Guitar lessons");

            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 3);
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

            System.out.println("Adding TRANSIENT course to the instructor: " + course1);
            instructor.addCourse(course1);

            System.out.println("Adding TRANSIENT course to the instructor: " + course2);
            instructor.addCourse(course2);

            System.out.println("Instructor now has the following TRANSIENT courses:");
            for(Course course : instructor.getCourses()) {
                System.out.println(course);
            }

            session.persist(course1);
            session.persist(course2);

            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }




    }
}
