package org.example.aopdemo.dao;

import org.example.aopdemo.models.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private int number;

    public void addAccount() {
        System.out.println(getClass() + " Adding an account...");
    }

    public void method_1(){
        System.out.println(getClass() + " method_1...");
    }

    public void method_2(int number, String string, Account account){
        System.out.println(getClass() + " method_2...");
    }

    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Giorgos", "Silver"));
        accounts.add(new Account("Maria", "Gold"));
        accounts.add(new Account("Antonis", "Platinum"));
        return accounts;
    }


    public int getNumber() {
        System.out.println(getClass() + " getNumber...");
        return number;
    }

    public void setNumber(int number) {
        System.out.println(getClass() + " setNumber...");
        this.number = number;
    }
}
