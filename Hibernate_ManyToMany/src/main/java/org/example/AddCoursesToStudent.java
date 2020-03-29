package org.example;

import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesToStudent {

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
            Student student = session.get(Student.class, 3);
            System.out.println("\n\nStudent retrieved: " + student);
            System.out.println("Courses of this student: " + student.getCourses() + "\n\n");

            int[] courses_ids = {10, 11};

            for(int course_id: courses_ids) {
                Course course = session.get(Course.class, course_id);
                System.out.println("Course retrieved: " + course);
                System.out.println("Students who have this course: " + course.getStudents());
                student.addCourseToStudent(course);
            }

            System.out.println("\n\nCourses of this student: " + student.getCourses() + "\n\n");

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }



    }
}
