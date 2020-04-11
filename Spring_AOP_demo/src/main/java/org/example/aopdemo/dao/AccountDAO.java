package org.example.aopdemo.dao;

import org.example.aopdemo.models.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class AccountDAO {
    
    private Logger logger = Logger.getLogger(getClass().getSimpleName());
    private int number;

    public void addAccount() {
        logger.info(getClass() + " Adding an account...");
    }

    public void method_1(){
        logger.info(getClass() + " method_1...");
    }

    public void method_2(int number, String string, Account account){
        logger.info(getClass() + " method_2...");
    }

    public List<Account> findAccounts(boolean throwException) {

        if(throwException) {
            throw  new RuntimeException("findAccounts exception!!");
        }

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Giorgos", "Silver"));
        accounts.add(new Account("Maria", "Gold"));
        accounts.add(new Account("Antonis", "Platinum"));
        return accounts;
    }


    public int getNumber() {
        logger.info(getClass() + " getNumber...");
        return number;
    }

    public void setNumber(int number) {
        logger.info(getClass() + " setNumber...");
        this.number = number;
    }
}
