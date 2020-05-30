package org.example.springboot.demo.MyFirstSpringBootDemo.dao;

import org.example.springboot.demo.MyFirstSpringBootDemo.models.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
