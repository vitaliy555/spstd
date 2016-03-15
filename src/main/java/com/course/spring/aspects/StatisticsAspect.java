package com.course.spring.aspects;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lombok.extern.java.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

@Aspect
@Component
@Log
public class StatisticsAspect {

    Map<String,Integer> storageLoggers = Maps.newHashMap();

    // name of method == pointcut name
    @Pointcut("execution(* com.course.spring.core.loggers.*.logEvent(..))")
    private void allLogEventMethods() {
    }

    @Before("allLogEventMethods()")
    private void logBefore(JoinPoint joinPoint) {
        String loggerName = joinPoint.getTarget().getClass().getSimpleName();
        Integer count = storageLoggers.get(loggerName);
        if(count!=null){
            storageLoggers.put(loggerName, ++count);
        }else {
            storageLoggers.put(loggerName, 1);
        }
    }

    @After("allLogEventMethods()")
    private void printCountOfExec() {
        storageLoggers.forEach((key,value)-> {System.out.println(key+" ---> "+value);});
    }
}
