package com.rxb.res.aop;

import org.springframework.stereotype.Component;

/**
 * Created by rxb on 2016/1/29.
 */
@Component
public class Human implements Sleepable {
    @Override
    public void sleep() {
        System.out.println("老夫要睡觉了!");
    }
}
