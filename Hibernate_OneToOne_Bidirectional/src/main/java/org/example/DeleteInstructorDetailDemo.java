package org.example;

import org.example.models.Instructor;
import org.example.models.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Objects;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int id = 5;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            System.out.println("InstructorDetail retrieved: " + instructorDetail);
            System.out.println("Associated Instructor: " + instructorDetail.getInstructor());

            if(!Objects.isNull(instructorDetail)) {

                System.out.println("Removing InstructorDetails from Instructor...");
                instructorDetail.getInstructor().setInstructorDetail(null);

                System.out.println("Deleting: " + instructorDetail);
                session.delete(instructorDetail);     // This will delete the instructor AND the instructorDetail because of CascadeType.ALL
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }




    }
}
