package com.rxb.res.main;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

import java.nio.charset.Charset;

/**
 * Created by rxb on 2016/1/26.
 */
public class SaltTest {
    String str = "hello";
    String salt = "123";
    String salt1 = "456";

    @Test
    public void test() {
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(Charset.defaultCharset());
    }

    @Test
    public void testMd5() {
        String md5 = new Md5Hash(str, salt).toString();
        //散列时还可以指定散列次数，如2次表
        String md51 = new Md5Hash(str, salt, 2).toString();
        String md52 = new Md5Hash(str, salt1).toString();
        String md5Base64 = new Md5Hash(str, salt).toBase64();
        String md5Hex = new Md5Hash(str, salt).toHex();

        System.out.println(md5);
        System.out.println(md52);
        System.out.println(md5Base64);
        System.out.println(md5Hex);
    }

    @Test
    public void testSha() {
        String sha256 = new Sha256Hash(str, salt).toString();//还可转化为base64和hex
        String sha1 = new SimpleHash("SHA-1", str, salt).toString();
        String sha512 = new SimpleHash("SHA-512", str, salt).toString();

        System.out.println(sha256);
        System.out.println(sha1);
        System.out.println(sha512);
    }
}
