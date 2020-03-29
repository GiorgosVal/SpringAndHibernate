package org.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "courses_students",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                '}';
    }


    /**
     * This is a util method to help with the uni-directional mapping.
     * @param review
     */
    public void addReview(Review review) {
        if(Objects.isNull(reviews)) {
            reviews = new ArrayList<>();
        }

        reviews.add(review);
    }

    public void addStudentToCourse(Student student) {
        if(Objects.isNull(students)) {
            students = new ArrayList<>();
        }

        if (!students.contains(student)) {
            students.add(student);
            System.out.println("Added student to the course.");
        } else {
            System.out.println("Student already enrolled for this course.");
        }
    }

    public void removeStudentFromCourse(Student student) {
        if(Objects.isNull(students) || students.isEmpty()) {
            System.out.println("No student has enrolled for this course.");
        } else if (!students.contains(student)) {
            System.out.println("Student has not enrolled for this course.");
        } else {
            students.remove(student);
            System.out.println("Student removed from the course.");
        }
    }
}
