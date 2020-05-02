package org.example.springrestdemo.mvc.services;

import org.example.springrestdemo.mvc.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> getMockList();
    Student getMockStudentById(int id);
}
