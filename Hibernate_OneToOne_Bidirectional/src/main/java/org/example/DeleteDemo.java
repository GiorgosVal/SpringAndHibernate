package org.example;

import org.example.models.Instructor;
import org.example.models.InstructorDetail;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Objects;

public class DeleteDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int id = 3;
            Instructor instructor = session.get(Instructor.class, id);

            System.out.println("Instructor retrieved: " + instructor);

            if(!Objects.isNull(instructor)) {
                System.out.println("Deleting: " + instructor);
                session.delete(instructor);     // This will delete the instructor AND the instructorDetail because of CascadeType.ALL
            }

            session.getTransaction().commit();

        } catch (HibernateException e) {

        } finally {
            session.close();
        }




    }
}
