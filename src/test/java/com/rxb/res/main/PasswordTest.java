package com.rxb.res.main;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rxb on 2016/1/26.
 */
public class PasswordTest {

    public String str = "hello";

    /**
     * 测试base64
     */
    @Test
    public void testBase64() {
        String base64Str = Base64.encodeToString(str.getBytes());
        System.out.println(base64Str);
        String str1 = Base64.decodeToString(base64Str);
        Assert.assertEquals(str,str1);
    }

    /**
     * 测试16进制
     */
    @Test
    public void testHex() {
        String hexStr = Hex.encodeToString(str.getBytes());
        System.out.println(hexStr);
        String str1 = new String(Hex.decode(hexStr.getBytes()));
        Assert.assertEquals(str, str1);
    }
}
