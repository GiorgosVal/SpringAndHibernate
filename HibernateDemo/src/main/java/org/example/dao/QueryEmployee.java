package org.example.dao;

import org.example.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryEmployee {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")         // we can simply do .configure() as it will default to hibernate.cfg.xml. If we have another name or location, here we can specify it explicitly.
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            @SuppressWarnings("unchecked")
            List<Employee> employees = session.createQuery("from Employee").getResultList();
            System.out.println("All employees");
            displayEmployees(employees);


            employees = session.createQuery("from Employee e where e.lastName='Val'").getResultList();
            System.out.println("Employees with lastName = 'Val'");
            displayEmployees(employees);

            employees = session.createQuery("from Employee e where e.email like '%gmail.com'").getResultList();
            System.out.println("Employees who use gmail:");
            displayEmployees(employees);

            employees = session.createQuery("from  Employee e where e.jobTitle not like '%President' OR e.firstName = 'Maria'").getResultList();
            System.out.println("Employee who are not President OR have first name Maria");
            displayEmployees(employees);




        } catch (Exception e) {
            System.out.println("Transaction was not completed.");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }


    }

    private static void displayEmployees(List<Employee> employees) {
        for(Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println();
    }


}
