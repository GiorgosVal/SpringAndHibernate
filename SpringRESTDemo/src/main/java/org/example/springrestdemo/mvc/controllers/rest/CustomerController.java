package org.example.springrestdemo.mvc.controllers.rest;

import org.example.springrestdemo.mvc.exceptions.BadRequestException;
import org.example.springrestdemo.mvc.exceptions.NotFoundException;
import org.example.springrestdemo.mvc.models.Customer;
import org.example.springrestdemo.mvc.responses.ApiResponse;
import org.example.springrestdemo.mvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id) {
        Customer customer = customerService.getCustomer(id);
        if(Objects.isNull(customer)) {
            throw new NotFoundException("Customer with id " + id + " was not found.");
        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {

        if(customer.getId() != 0) {
            customer.setId(0);
            throw new BadRequestException("POST request cannot have id specified. Remove id or set it to 0 (see suggestion)." +
                    "If your intent it to make an update, use PUT method instead.", customer);
        }

        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {

        if(customer.getId() == 0) {
            customer.setId(Integer.MAX_VALUE);
            throw new BadRequestException("PUT request must have id specified (see suggestion)." +
                    "If your intent it to create data, use POST method instead.", customer);
        }

        if(Objects.isNull(customerService.getCustomer(customer.getId()))) {
            throw new NotFoundException("Customer with the specified id was not found.");
        }

        customerService.updateCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public ApiResponse deleteCustomer(@PathVariable int id) {

        Customer customer = customerService.getCustomer(id);

        if(Objects.isNull(customer)) {
            throw new NotFoundException("Customer with id " + id + " was not found.");
        }

        customerService.deleteCustomerById(id);
        return new ApiResponse(HttpStatus.OK.value(), "Deleted customer with id: " + id, System.currentTimeMillis());
    }
}
