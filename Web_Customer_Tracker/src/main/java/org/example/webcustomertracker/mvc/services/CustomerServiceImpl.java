package org.example.webcustomertracker.mvc.services;

import org.example.webcustomertracker.mvc.dao.CustomerDAO;
import org.example.webcustomertracker.mvc.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDao;

    @Override
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    public void deleteCustomerById(int id) {
        customerDao.deleteCustomerById(id);
    }

    @Override
    public Customer getCustomer(int id) {
        return customerDao.getCustomer(id);
    }
}
