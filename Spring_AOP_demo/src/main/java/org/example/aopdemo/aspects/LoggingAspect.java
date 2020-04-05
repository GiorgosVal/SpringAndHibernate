package org.example.aopdemo.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final String POINTCUT_DECLARATION = "execution(public void method_1())";

    @Pointcut("execution(* org.example.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* org.example.aopdemo.dao.*.get*(..))")
    private void forDaoGetters(){}

    @Pointcut("execution(* org.example.aopdemo.dao.*.set*(..))")
    private void forDaoSetters(){}

    @Pointcut("forDaoPackage() && !(forDaoGetters() || forDaoSetters())")
    private void forDaoNoGetterSetter(){}

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


    @Before(POINTCUT_DECLARATION)
    public void beforeMethod_1() {
        System.out.println("\n==> @Before advice on method_1().");
    }

    @After(POINTCUT_DECLARATION)
    public void afterMethod_1() {
        System.out.println("==> @After advice on method_1().\n");
    }

    @Before("forDaoPackage() && !(forDaoGetters() || forDaoSetters())")
    public void beforeAnyDaoMethodNotGetterOrSetter() {
        System.out.println("\n==> @Before advice on ANY DAO method excluding getters/setters 1.");
    }

    @After("forDaoPackage() && !(forDaoGetters() || forDaoSetters())")
    public void afterAnyDaoMethodNotGetterOrSetter() {
        System.out.println("==> @After advice on ANY DAO method excluding getters/setters 1.\n");
    }

    @Before("forDaoNoGetterSetter()")
    public void beforeAnyDaoMethodNotGetterOrSetter_2() {
        System.out.println("\n==> @Before advice on ANY DAO method excluding getters/setters 2.");
    }

    @After("forDaoNoGetterSetter()")
    public void afterAnyDaoMethodNotGetterOrSetter_2() {
        System.out.println("==> @After advice on ANY DAO method excluding getters/setters 2.\n");
    }








}
