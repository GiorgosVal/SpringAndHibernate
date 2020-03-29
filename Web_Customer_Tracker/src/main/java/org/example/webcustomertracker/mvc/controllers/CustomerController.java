package org.example.webcustomertracker.mvc.controllers;

import org.example.webcustomertracker.mvc.dao.CustomerDAO;
import org.example.webcustomertracker.mvc.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDao;

    @RequestMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> customers = customerDao.getCustomers();

        model.addAttribute("customers", customers);

        return "list_customers";
    }

}
