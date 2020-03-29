package org.example;

import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddStudentsToCourse {

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
            session.beginTransaction();
            Course course = session.get(Course.class, 17);
            System.out.println("Course retrieved: " + course);
            System.out.println("Students who have this course: " + course.getStudents());

            int[] student_ids = {2, 3};

            for(int student_id : student_ids) {
                Student student = session.get(Student.class, student_id);
                System.out.println("Student retrieved: " + student);
                System.out.println("Courses of this student: " + student.getCourses());
                course.addStudentToCourse(student);
            }

            System.out.println("Students who have this course: " + course.getStudents());
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }



    }
}
