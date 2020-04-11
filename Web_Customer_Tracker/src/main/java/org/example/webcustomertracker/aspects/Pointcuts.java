package org.example.webcustomertracker.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Pointcuts {

    @Pointcut("execution(* org.example.webcustomertracker.mvc.controllers.*.*(..))")
    public void forControllersPackage() {}

    @Pointcut("execution(* org.example.webcustomertracker.mvc.services.*.*(..))")
    public void forServicesPackage() {}

    @Pointcut("execution(* org.example.webcustomertracker.mvc.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("forControllersPackage() || forServicesPackage() || forDaoPackage()")
    public void forAppFlow(){}
}
