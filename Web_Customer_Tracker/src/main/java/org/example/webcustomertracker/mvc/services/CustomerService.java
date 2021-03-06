package org.example.webcustomertracker.mvc.services;

import org.example.webcustomertracker.mvc.models.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();
    Customer getCustomer(int id);
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(int id);
}
