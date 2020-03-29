package org.example;

import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudents {

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
            Student student1 = new Student("Giorgos", "Valam", "val@email.com");
            Student student2 = new Student("Maria", "Pappa", "maria@email.com");
            Student student3 = new Student("Antonis", "Kyriakou", "antonis@email.com");
            Student student4 = new Student("Panagiotis", "Strournaras", "panagi@email.com");

            session.beginTransaction();

            session.persist(student1);
            session.persist(student2);
            session.persist(student3);
            session.persist(student4);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }



    }
}
