package com.briup.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RoleAspect {
    //注意，方法名字就是这个切入点的名字
    @Pointcut("execution(* com.briup.aop.aspect..*.*(..))")
    public void pointcut1() {}

    //注意，方法名字就是这个切入点的名字
    @Pointcut("execution(* com.briup.aop.aspect..*.delete*(..))")
    public void pointcut2() {}

    @Before("pointcut1()")
    public void before() {
        System.out.println("before...");
    }

    @After("pointcut1()")
    public void after() {
        System.out.println("after...");
    }

    @AfterReturning("pointcut1()")
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    @AfterThrowing("pointcut2()")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    @Around("pointcut1()")
    public void around(ProceedingJoinPoint jp) {
        System.out.println("around-before");
        try {
            jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around-after");
    }
}