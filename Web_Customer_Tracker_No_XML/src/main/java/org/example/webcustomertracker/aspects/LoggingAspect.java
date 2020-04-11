package org.example.webcustomertracker.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getSimpleName());

    @Before("org.example.webcustomertracker.aspects.Pointcuts.forAppFlow()")
    public void before(JoinPoint joinPoint) {
        System.out.println("/////////////////////////////////////////");
        logger.info(getMethodNameAndArgs(joinPoint));
    }

    @AfterReturning(pointcut = "org.example.webcustomertracker.aspects.Pointcuts.forAppFlow()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Returning from method \"" + joinPoint.getSignature().getName() + "\"" +
                " with result [" + result + "].");
    }


    private String getMethodNameAndArgs(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        StringBuilder builder = new StringBuilder();
        builder.append("Calling method \"" + methodName + "\"");

        if (!Objects.isNull(arguments) && arguments.length != 0) {
            builder.append(" with arguments [");
            for (Object arg : arguments) {
                builder.append(arg.getClass() + ":" + arg + ",");
            }
            builder.deleteCharAt(builder.lastIndexOf(","));
            builder.append("].");
        } else {
            builder.append(" with no arguments.");
        }
        return builder.toString();
    }


    @Before("org.example.webcustomertracker.aspects.Pointcuts.forControllersPackage_2()")
    public void allGet(){
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////");
    }


}
