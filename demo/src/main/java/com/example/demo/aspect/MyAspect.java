package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class MyAspect {
    @Pointcut("execution(* com.example.demo.constant.ABean.*(..))")
    public void pointcut(){
        System.out.println("1232132");
    }
    @Before("pointcut()")
    public void before(){
        System.out.println("before");
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
