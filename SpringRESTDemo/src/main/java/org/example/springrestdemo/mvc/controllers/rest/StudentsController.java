package org.example.springrestdemo.mvc.controllers.rest;

import org.example.springrestdemo.mvc.exceptions.StudentNotFoundException;
import org.example.springrestdemo.mvc.models.Student;
import org.example.springrestdemo.mvc.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/mocklist")
    public List<Student> getMockStudentList() {
        return studentService.getMockList();
    }

    @GetMapping("/mocklist/{id}")
    public Student getStudentByIdFromMockList(@PathVariable int id) {
        Student student = studentService.getMockStudentById(id);

        if(Objects.isNull(student)) {
            throw new StudentNotFoundException("Student with id \"" + id + "\" was not found.");
        }

        return studentService.getMockStudentById(id);
    }


}
