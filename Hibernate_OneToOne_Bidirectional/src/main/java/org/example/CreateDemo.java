package org.example;

import org.example.models.Instructor;
import org.example.models.InstructorDetail;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Instructor instructor = new Instructor("Paraskevi", "Sarioglou", "frida@email.com");
            InstructorDetail instructorDetail = new InstructorDetail("AwesomeMusic", "GIS");
            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            // This will save the instructor AND the instructorDetail because of CascadeType.ALL
            session.persist(instructor);

            session.getTransaction().commit();

        } catch (HibernateException e) {

        } finally {
            session.close();
        }




    }
}
