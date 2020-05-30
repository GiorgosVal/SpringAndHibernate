package org.example.springboot.demo.MyFirstSpringBootDemo.services;

import org.example.springboot.demo.MyFirstSpringBootDemo.dao.EmployeeDAOSpringDataJpa;
import org.example.springboot.demo.MyFirstSpringBootDemo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service (value = "employeeService")
//@Transactional      // No need for @Transactional - JpaRepository provides it
public class EmployeeServiceImpl_forSpringDataJPA implements EmployeeService {

    private EmployeeDAOSpringDataJpa employeeDAOSpringDataJpa;

    @Autowired
    public EmployeeServiceImpl_forSpringDataJPA(EmployeeDAOSpringDataJpa employeeDAOSpringDataJpa) {
        this.employeeDAOSpringDataJpa = employeeDAOSpringDataJpa;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDAOSpringDataJpa.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> optional = employeeDAOSpringDataJpa.findById(id);
        Employee employee;

        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Did not find the employee id: " + id);
        }

        return employee;
    }

    @Override
    public void save(Employee employee) {
        this.employeeDAOSpringDataJpa.save(employee);
    }

    @Override
    public void deleteById(int id) {
        this.employeeDAOSpringDataJpa.deleteById(id);
    }
}
