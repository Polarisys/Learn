package com.spring.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @anthor Tolaris
 * @date 2020/8/14 - 21:16
 */
@Component
@Aspect
public class Aspectj {

    @Pointcut("execution(* com.spring.dao.*.*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public void before(ProceedingJoinPoint joinPoint) {
        System.out.println("before");
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                args[i] += "world";
            }
        }
        try {
            joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after");
    }
}
