package org.example.springrestdemo.mvc.services;

import org.example.springrestdemo.mvc.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService{
    @Override
    public List<Student> getMockList() {
        List<Student> students = new ArrayList<>();
        Student student = new Student(1, "Jon", "Doe");
        students.add(student);

        student = new Student(2, "Mario", "Rossi");
        students.add(student);

        student = new Student(3, "Maria", "O'neil");
        students.add(student);
        return students;
    }

    @Override
    public Student getMockStudentById(int id) {
        List<Student> students = getMockList();
        Student student = null;

        for(Student st : students) {
            if (st.getId() == id) {
                student = st;
                break;
            }
        }
        return student;
    }
}
