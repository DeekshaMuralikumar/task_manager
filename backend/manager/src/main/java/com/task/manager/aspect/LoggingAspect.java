package com.task.manager.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.task.manager.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Method called: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.task.manager.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Method finished: " + joinPoint.getSignature().getName());
    }
}