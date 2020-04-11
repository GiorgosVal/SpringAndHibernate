package org.example.aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.example.aopdemo.models.Account;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Order(2)
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getSimpleName());

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
        logger.info("\n==> @Before advice on addAccount().");
    }


    @Before(POINTCUT_DECLARATION)
    public void beforeMethod_1() {
        logger.info("\n==> @Before advice on method_1().");
    }

    @After(POINTCUT_DECLARATION)
    public void afterMethod_1() {
        logger.info("==> @After advice on method_1().\n");
    }

    @Before("forDaoPackage() && !(forDaoGetters() || forDaoSetters())")
    public void beforeAnyDaoMethodNotGetterOrSetter() {
        logger.info("\n==> @Before advice on ANY DAO method excluding getters/setters 1.");
    }

    @After("forDaoPackage() && !(forDaoGetters() || forDaoSetters())")
    public void afterAnyDaoMethodNotGetterOrSetter() {
        logger.info("==> @After advice on ANY DAO method excluding getters/setters 1.\n");
    }

    @Before("forDaoNoGetterSetter()")
    public void beforeAnyDaoMethodNotGetterOrSetter_2() {
        logger.info("\n==> @Before advice on ANY DAO method excluding getters/setters 2.");
    }

    @After("forDaoNoGetterSetter()")
    public void afterAnyDaoMethodNotGetterOrSetter_2() {
        logger.info("==> @After advice on ANY DAO method excluding getters/setters 2.\n");
    }



    @Before("org.example.aopdemo.aspects.AopExpressions.daoNoGetterSetter()")
    public void performLogging(JoinPoint joinPoint) {
        logger.info("\n==> Performing Logging.");

        Signature signature = joinPoint.getSignature();
        logger.info("Method called: " + signature.toString());

        Object[] arguments = joinPoint.getArgs();
        for(Object arg : arguments) {
            logger.info("Argument: " + arg.toString());
        }
    }

    @AfterReturning(pointcut = "org.example.aopdemo.aspects.AopExpressions.findAccounts()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, List<Account> result) {
        logger.info("\n===> @AfterReturning START advice on method: " + joinPoint.getSignature().toString());
        result.forEach(System.out::println);
        logger.info("===> @AfterReturning END advice on method: " + joinPoint.getSignature().toString() + "\n");
        postProcessData(result);
    }

    private void postProcessData(List<Account> accounts) {
        accounts.forEach(account -> account.setLevel(account.getLevel().toUpperCase()));
    }


    @AfterThrowing(pointcut = "org.example.aopdemo.aspects.AopExpressions.findAccounts()", throwing = "anException")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable anException) {
        logger.info("\n===> @AfterThrowing advice on method: " + joinPoint.getSignature().toString());
        logger.info("\n===> @AfterThrowing advice: The exception is " + anException.toString());
    }

    @After("org.example.aopdemo.aspects.AopExpressions.findAccounts()")
    public void afterFindAccountsAdvice(JoinPoint joinPoint) {
        logger.info("\n===> @After advice on method: " + joinPoint.getSignature().toString());
    }

    @Around("org.example.aopdemo.aspects.AopExpressions.findAccounts()")
    public Object aroundFindAccountsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("\n===> @Around advice on method: " + proceedingJoinPoint.getSignature().toString());

        long start = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.info("===> @Around method time to execute: " + (end - start) + "ms.");

        return object;
    }

    @Before("org.example.aopdemo.aspects.AopExpressions.findAccounts()")
    public void aroundFindAccountsAdvice(JoinPoint joinPoint) {
        logger.info("\n===> @Before advice on method: " + joinPoint.getSignature().toString());
    }



    @Around("org.example.aopdemo.aspects.AopExpressions.getSomeValue()")
    public Object aroundgetSomeValueAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object object;

        try {
            object = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.warning(e.getMessage());
            object = "Some value by AOP handling.";
        }

        return object;
    }

    @Around("org.example.aopdemo.aspects.AopExpressions.getSomeValue_2()")
    public Object aroundgetSomeValue_2Advice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object object;

        try {
            object = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.warning(e.getMessage());
            throw e;
        }

        return object;
    }





}
