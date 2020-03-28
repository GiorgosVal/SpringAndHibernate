package org.example;

import org.example.models.Course;
import org.example.models.Instructor;
import org.example.models.InstructorDetail;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class FetchJoinDemo {

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

            int id = 1;
            Query<Instructor> query = session.createQuery("select i from Instructor i join fetch i.courses where i.id=:argument", Instructor.class);
            query.setParameter("argument", id);

            Instructor instructor = query.getSingleResult();

            System.out.println("Instructor retrieved: " + instructor);

            session.getTransaction().commit();
            session.close();

            // session closed

            List<Course> courses = instructor.getCourses();

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
