package com.yszt.base.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 专用解决跨域问题。
 * @author qiaolin
 * @version 2017年2月21日
 * 
 */
public class ResponseHeadInterceptor implements HandlerInterceptor{
	Logger log = Logger.getLogger(ResponseHeadInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		log.debug(response.getHeader("Access-Control-Allow-Origin"));
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	
		
	}
}
