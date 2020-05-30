package org.example.springboot.demo.MyFirstSpringBootDemo.dao;

import org.example.springboot.demo.MyFirstSpringBootDemo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//No need for @Repository
@RepositoryRestResource(path = "members")
public interface EmployeeDAOSpringDataJpa extends JpaRepository<Employee, Integer> {
}
