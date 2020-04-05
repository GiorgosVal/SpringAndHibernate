package org.example.aopdemo.runners;

import org.example.aopdemo.congif.AppConfig;
import org.example.aopdemo.dao.AccountDAO;
import org.example.aopdemo.models.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        accountDAO.addAccount();
        accountDAO.method_1();
        accountDAO.method_2(3, "some string", new Account("Giorgos", "Boss"));
        accountDAO.setNumber(1);
        accountDAO.getNumber();
        context.close();


    }
}
