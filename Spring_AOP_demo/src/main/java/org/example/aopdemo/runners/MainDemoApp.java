package org.example.aopdemo.runners;

import org.example.aopdemo.congif.AppConfig;
import org.example.aopdemo.dao.AccountDAO;
import org.example.aopdemo.models.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainDemoApp {
    
    private static Logger logger = Logger.getLogger(MainDemoApp.class.getSimpleName());
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
       // accountDAO.addAccount();
       // accountDAO.method_1();
        //accountDAO.method_2(3, "some string", new Account("Giorgos", "Boss"));
        //accountDAO.setNumber(1);
        //accountDAO.getNumber();
        logger.info("\nBefore the actual line of code that calls the method.");
        List<Account> accountList = null;

        try {
            boolean throwException = false;
            accountList = accountDAO.findAccounts(throwException);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Main program... exception caught. " + e.toString());
        }

        logger.info("\nAfter the actual line of code that called the method.");
        accountList.forEach(a -> logger.info(a.toString()));
        context.close();


    }
}
