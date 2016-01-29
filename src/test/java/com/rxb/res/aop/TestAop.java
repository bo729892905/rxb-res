package com.rxb.res.aop;

import com.rxb.res.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by rxb on 2016/1/29.
 */
public class TestAop extends BaseTest {
    @Autowired
    Sleepable human;

    @Test
    public void test() {
        human.sleep();
    }
}
