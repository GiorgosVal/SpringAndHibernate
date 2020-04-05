package org.example.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {

    @Pointcut("execution(* org.example.aopdemo.dao.*.*(..))")
    protected void dao(){}

    @Pointcut("execution(* org.example.aopdemo.dao.*.get*(..))")
    protected void daoGetters(){}

    @Pointcut("execution(* org.example.aopdemo.dao.*.set*(..))")
    protected void daoSetters(){}

    @Pointcut("dao() && !(daoGetters() || daoSetters())")
    protected void daoNoGetterSetter(){}
}
