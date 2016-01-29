package com.rxb.res.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by rxb on 2016/1/29.
 */
@Aspect
@Component
public class SleepHelper {

    /**
     * sleep切点
     */
    @Pointcut("execution(* com.rxb.res.aop.*.sleep(..))")
    public void sleepPoint() {

    }

    @Before("sleepPoint()")
    public void beforeSleep() {
        System.out.println("睡觉前要脱衣服。");
    }

    @AfterReturning("sleepPoint()")
    public void afterSleep() {
        System.out.println("醒了要穿衣服。");
    }

}
