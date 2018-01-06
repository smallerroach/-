package com.yszt.base.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.springframework.web.context.ContextLoader;
//import org.springframework.web.context.WebApplicationContext;

public class ServerListerner implements ServletContextListener {
	protected final Logger logger = LogManager.getLogger(this.getClass());

	public void contextDestroyed(ServletContextEvent contextEvent) {
	}

	public void contextInitialized(ServletContextEvent contextEvent) {
//		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
	
		logger.info("=================================");
		//logger.info("系统[{}]启动完成!!!", contextEvent.getServletContext().getServletContextName());
		logger.info("=================================");
	}
}