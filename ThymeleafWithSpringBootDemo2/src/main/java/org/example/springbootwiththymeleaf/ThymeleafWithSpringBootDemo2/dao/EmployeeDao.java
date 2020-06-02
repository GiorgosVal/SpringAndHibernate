package org.example.springbootwiththymeleaf.ThymeleafWithSpringBootDemo2.dao;

import org.example.springbootwiththymeleaf.ThymeleafWithSpringBootDemo2.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    // Spring Data JPA parses the method's name and creates an appropriate query
    List<Employee> findAllByFirstNameNotNullAndLastNameNotNullAndEmailNotNullOrderByLastNameAsc();
    List<Employee> findAllByFirstNameNotNullAndLastNameNotNullAndEmailNotNullOrderByLastNameDesc();

}
