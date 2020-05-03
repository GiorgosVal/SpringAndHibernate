package org.example.springrestdemo.mvc.dao;

import org.example.springrestdemo.mvc.models.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerDao")
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public Customer getCustomer(int id) {
        return sessionFactory.getCurrentSession().get(Customer.class, id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        Customer updated = (Customer)session.merge(customer);
        System.out.println("Updating customer..." + customer);
        return updated;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteCustomerById(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
        return false;
    }

    @Override
    public boolean saveCustomer(Customer customer) {
        sessionFactory.getCurrentSession().persist(customer);
        System.out.println("Saving customer..." + customer);
        return false;
    }
}
