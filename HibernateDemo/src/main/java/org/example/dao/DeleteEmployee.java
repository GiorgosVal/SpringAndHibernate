package org.example.dao;

import org.example.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")         // we can simply do .configure() as it will default to hibernate.cfg.xml. If we have another name or location, here we can specify it explicitly.
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 8);
            System.out.println("Employee retrieved: " + employee);

            System.out.println("Deleting employee...");
            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Done.\n");


            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("delete from Employee where employeeId = 7").executeUpdate();

            session.getTransaction().commit();


        } catch (Exception e) {
            System.out.println("Transaction was not completed.");
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }


    }


}
