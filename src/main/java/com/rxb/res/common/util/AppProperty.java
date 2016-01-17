package com.rxb.res.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置属性（对应application.properties中的属性）
 * Created by rxb on 2016/1/17.
 */
@Component("appProperty")
public class AppProperty {
    @Value("${accessKeyId}")
    private String accessKeyId;
    @Value("${secretAccessKey}")
    private String secretAccessKey;
    @Value("${endpoint}")
    private String endpoint;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
