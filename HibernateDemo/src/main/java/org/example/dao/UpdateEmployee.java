package org.example.dao;

import org.example.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

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
            employee.setLastName("Pappadopoulou");
            session.getTransaction().commit();
            System.out.println("Done.\n");


            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Updating all employees...");
            session.createQuery("update Employee set reportsTo = 2 where employeeId not between 1 and 2").executeUpdate();
            session.createQuery("update Employee set reportsTo = 1 where employeeId = 2").executeUpdate();
            session.createQuery("update Employee set reportsTo = 0 where employeeId = 1").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done.");

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee1 = session.get(Employee.class, 1);
            employee1.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("14/11/1987"));
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Transaction was not completed.");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }


    }


}
