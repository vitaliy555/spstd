package com.course.spring.aspects;

import lombok.extern.java.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.omg.CORBA.Object;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
@Log
public class Loggingaspect {

    // name of method == pointcut name
   @Pointcut("execution(* *.logEvent(..))")
    private void allLogEventMethods() {
    }

    @Before("allLogEventMethods()")
    private void logBefore(JoinPoint joinPoint) {
        log.info("Before : " + joinPoint.getTarget().getClass().getSimpleName() + " " +
                joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "allLogEventMethods()",returning = "retVal")
    private void logAfter(Object retVal){
        log.info("Returning value : "+retVal);
    }
}
