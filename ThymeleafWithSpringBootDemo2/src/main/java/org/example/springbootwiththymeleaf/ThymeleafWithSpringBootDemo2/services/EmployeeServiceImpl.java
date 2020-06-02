package org.example.springbootwiththymeleaf.ThymeleafWithSpringBootDemo2.services;

import org.example.springbootwiththymeleaf.ThymeleafWithSpringBootDemo2.dao.EmployeeDao;
import org.example.springbootwiththymeleaf.ThymeleafWithSpringBootDemo2.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> optionalEmployee = employeeDao.findById(id);
        Employee employee;

        if(optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();
        } else {
            throw new RuntimeException("Did not find employee with id " + id);
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }

    @Override
    public List<Employee> findAllOrderByLastNameAsc() {
        return employeeDao.findAllByFirstNameNotNullAndLastNameNotNullAndEmailNotNullOrderByLastNameAsc();
    }

    @Override
    public List<Employee> findAllOrderByLastNameDesc() {
        return employeeDao.findAllByFirstNameNotNullAndLastNameNotNullAndEmailNotNullOrderByLastNameDesc();
    }
}
