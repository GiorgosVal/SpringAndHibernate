package org.example.springbootwiththymeleaf.ThymeleafWithSpringBootDemo2.services;

import org.example.springbootwiththymeleaf.ThymeleafWithSpringBootDemo2.models.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee employee);
    void deleteById(int id);

    List<Employee> findAllOrderByLastNameAsc();
    List<Employee> findAllOrderByLastNameDesc();
}
