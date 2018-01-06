package com.yszt.base.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 */
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DataSourceAspect {
	private final Logger logger = LogManager.getLogger();

	@Pointcut("execution(* com.yszt.*..*Mapper.*(..))")
	public void aspect() {
	}

	/**
	 * 配置前置通知,使用在方法aspect()上注册的切入点
	 */
	@Before("aspect()")
	public void before(JoinPoint point) {
	
		HandleDataSource.putDataSource("mysql");
	
	}

	@After("aspect()")
	public void after(JoinPoint point) {
		HandleDataSource.clear();
	}
}
