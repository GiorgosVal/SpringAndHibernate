package org.example.springrestdemo.mvc.services;

import org.example.springrestdemo.mvc.models.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();
    Customer getCustomer(int id);
    void saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomerById(int id);
}
