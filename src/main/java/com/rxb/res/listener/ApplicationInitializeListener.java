package com.rxb.res.listener;

import com.rxb.res.common.AppProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationInitializeListener implements ServletContextListener {
	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	public void contextDestroyed(ServletContextEvent event) {
		logger.debug("---------资源项目结束...");
	}

	public void contextInitialized(ServletContextEvent event) {
		logger.debug("---------资源项目启动...");
		WebApplicationContext applicationContext=getAppliationContext(event);
		try{			
			initData(applicationContext);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取WebApplicationContext
	 * @param event
	 * @return
	 */
	public WebApplicationContext getAppliationContext(ServletContextEvent event){
		ServletContext servletContext=event.getServletContext();
		WebApplicationContext applicationContext=WebApplicationContextUtils.getWebApplicationContext(servletContext);
		return applicationContext;
	}

	public void initData(WebApplicationContext applicationContext){
		ServletContext context = applicationContext.getServletContext();
        if(context == null) {
            logger.warn("ServletContext is null!");
        }
        
        /*UserService userService=applicationContext.getBean(UserService.class);
        User user=new User("test1","123","ase",false);
		int result=userService.insertUser(user);
		if(result!=0) logger.debug("初始化用户成功！");*/

		AppProperty appProperty=(AppProperty) applicationContext.getBean("appProperty");
        logger.debug(appProperty.getAccessKeyId());
	}
	
}
