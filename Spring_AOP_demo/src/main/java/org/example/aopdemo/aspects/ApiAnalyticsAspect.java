package org.example.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(value = -10)
@Component
public class ApiAnalyticsAspect {

    @Before("org.example.aopdemo.aspects.AopExpressions.daoNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n==> Performing API analytics.");
    }

}
