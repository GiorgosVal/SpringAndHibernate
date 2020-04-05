package org.example.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(value = 5)
@Component
public class CloudLogAsyncAspect {

    @Before("org.example.aopdemo.aspects.AopExpressions.daoNoGetterSetter()")
    public void performCloudLogAsync() {
        System.out.println("\n==> Performing Cloud log async.");
    }

}
