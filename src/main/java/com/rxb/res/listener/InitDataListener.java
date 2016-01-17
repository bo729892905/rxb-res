package com.rxb.res.listener;

import com.rxb.res.common.util.AppProperty;
import com.rxb.res.common.util.SystemConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 初始化数据
 * @author rxb
 *
 * 2015年12月28日
 */
public class InitDataListener implements InitializingBean {
	
	@Autowired
	private AppProperty appProperty;

	public void afterPropertiesSet() throws Exception {
		SystemConfig.accessKeyId=appProperty.getAccessKeyId();
		SystemConfig.secretAccessKey=appProperty.getSecretAccessKey();
		SystemConfig.endpoint=appProperty.getEndpoint();
	}

}
