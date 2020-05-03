package org.example.springrestdemo.mvc.dao;

import org.example.springrestdemo.mvc.models.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();
    Customer getCustomer(int id);
    Customer updateCustomer(Customer customer);
    boolean deleteCustomer(Customer customer);
    boolean deleteCustomerById(int id);
    boolean saveCustomer(Customer customer);

}
