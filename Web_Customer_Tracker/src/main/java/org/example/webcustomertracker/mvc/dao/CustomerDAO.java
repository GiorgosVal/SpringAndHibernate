package org.example.webcustomertracker.mvc.dao;

import org.example.webcustomertracker.mvc.models.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();
    Customer getCustomer(int id);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(Customer customer);
    boolean deleteCustomerById(int id);
    boolean saveCustomer(Customer customer);

}
