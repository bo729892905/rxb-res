package com.rxb.res.main;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Test;

/**
 * Created by rxb on 2016/1/26.
 */
public class HashServiceTest {
    @Test
    public void test() {
        DefaultHashService hashService = new DefaultHashService();//默认算法SHA-512
        hashService.setHashAlgorithmName("SHA-512");
        hashService.setPrivateSalt(new SimpleByteSource("123"));//私盐，默认物
        hashService.setGeneratePublicSalt(true);//是否生成公盐
        hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());//用于生成共有盐，默认是这个
        hashService.setHashIterations(1);//生成hash值的迭代次数

        HashRequest request = new HashRequest.Builder()
                .setAlgorithmName("MD5").setSource(ByteSource.Util.bytes("hello"))
                .setSalt(ByteSource.Util.bytes("123")).setIterations(2).build();
        String hex = hashService.computeHash(request).toHex();
        System.out.println(hex);
    }
}
