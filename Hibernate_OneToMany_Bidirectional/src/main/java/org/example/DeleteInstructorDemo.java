package org.example;

import org.example.models.Course;
import org.example.models.Instructor;
import org.example.models.InstructorDetail;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;

public class DeleteInstructorDemo {

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

            Instructor instructor = session.get(Instructor.class, 3);
            System.out.println("Instructor retrieved: " + instructor);

            Iterator<Course> iterator = instructor.getCourses().iterator();
            while (iterator.hasNext()) {
                Course course = iterator.next();
                System.out.println("Removing course from instructor: " + course);
                instructor.removeCourse(course);
            }


            System.out.println("Deleting instructor...");
            session.delete(instructor);


            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }




    }
}
