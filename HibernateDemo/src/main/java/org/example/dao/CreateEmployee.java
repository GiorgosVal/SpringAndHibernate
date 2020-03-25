package org.example.dao;

import org.example.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployee {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")         // we can simply do .configure() as it will default to hibernate.cfg.xml. If we have another name or location, here we can specify it explicitly.
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Creating a new Employee object...");
            Employee employee = new Employee("Paraskevi", "Sarrioglou", "psarri@val.com", "16", 102, "Sales Rep");

            System.out.println("Starting transaction...");
            session.beginTransaction();

            System.out.println("Saving the employee...");
            session.save(employee);

            System.out.println("Committing the transaction...");
            session.getTransaction().commit();

            System.out.println("Done.");


        } catch (Exception e) {
            System.out.println("Transaction not completed.");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally block.");

            session.close();

        }


    }


}
