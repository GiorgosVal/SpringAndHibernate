package org.example.springboot.demo.MyFirstSpringBootDemo.services;

import org.example.springboot.demo.MyFirstSpringBootDemo.dao.EmployeeDAO;
import org.example.springboot.demo.MyFirstSpringBootDemo.dao.EmployeeDAOSpringDataJpa;
import org.example.springboot.demo.MyFirstSpringBootDemo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service (value = "employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;
    private EmployeeDAOSpringDataJpa employeeDAOSpringDataJpa;

    @Autowired
    public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Autowired
    public EmployeeServiceImpl(EmployeeDAOSpringDataJpa employeeDAOSpringDataJpa) {
        this.employeeDAOSpringDataJpa = employeeDAOSpringDataJpa;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return this.employeeDAO.findById(id);
    }

    @Override
    public void save(Employee employee) {
        this.employeeDAO.save(employee);
    }

    @Override
    public void deleteById(int id) {
        this.employeeDAO.deleteById(id);
    }
}
