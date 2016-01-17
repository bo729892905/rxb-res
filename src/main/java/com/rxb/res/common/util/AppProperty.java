package com.rxb.res.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置属性
 * Created by rxb on 2016/1/17.
 */
@Component("appProperty")
public class AppProperty {
    @Value("${accessKeyId}")
    private String accessKeyId;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }
}
