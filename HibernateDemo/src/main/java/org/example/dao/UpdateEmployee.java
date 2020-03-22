package org.example.dao;

import org.example.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")         // we can simply do .configure() as it will default to hibernate.cfg.xml. If we have another name or location, here we can specify it explicitly.
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 2);
            System.out.println("Employee retrieved: " + employee);

            System.out.println("Updating employee...");
            employee.setLastName("Pappa");
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Transaction was not completed.");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }


    }


}
