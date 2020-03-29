package org.example.webcustomertracker.mvc.dao;

import org.example.webcustomertracker.mvc.models.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();
    Customer getCustomer();
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(Customer customer);
    boolean saveCustomer(Customer customer);

}
