package org.example.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public void addAccount())")
    //@Before("execution(void addAccount())")
    //@Before("execution(boolean addAccount())")
    //@Before("execution(org.example.aopdemo.dao.AccountDAO addAccount())")
    //@Before("execution(* addAccount())")
    //@Before("execution(* add*())")
    //@Before("execution(* add*nt())")
    //@Before("execution(* a*d*nt())")
    //@Before("execution(* *Account())")
    //@Before("execution(* *Account(..))")
    //@Before("execution(void org.example.aopdemo.dao.AccountDAO.addAccount(..) throws IllegalAccessException)")
    //@Before("execution(void *.*.*.*.AccountDAO.addAccount(..))")
    //@Before("execution(void *.*.*.dao.*.addAccount(..))")
    //@Before("execution(void *.ex*le.*.*.AccountDAO.addAccount(..))")
    //@Before("execution(void org.example.aopdemo.dao.AccountDAO.*(..))")
    //@Before("execution(void org.example.aopdemo.dao.*.*(..))")
    //@Before("execution(void org.example.aopdemo.dao.*.*())")
    //@Before("execution(void org.example.aopdemo.dao.*.*(org.example.aopdemo.dao.AccountDAO))")
    //@Before("execution(void addAccount(*))")
    //@Before("execution(void addAccount(..))")
    //@Before("execution(void addAccount(int, int))")
    //@Before("execution(void addAccount(int, ..))")
    //@Before("execution(void addAccount(int, *))")
    //@Before("execution(void addAccount(int, ..) throws Illegal*)")
    //@Before("execution(void addAccount(int, ..) throws Illegal*Exception)")
    //@Before("execution(void addAccount(int, ..) throws *)")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==> @Before advice on addAccount().");
    }
}
