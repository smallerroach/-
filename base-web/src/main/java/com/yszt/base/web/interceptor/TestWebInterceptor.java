package com.yszt.base.web.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * 测试通过WebRequestInterceptor接口来定义拦截器。
 * @author qiaolin
 * @version 2017年2月21日
 * 
 */
public class TestWebInterceptor implements WebRequestInterceptor{

	@Override
	public void preHandle(WebRequest request) throws Exception {
		request.setAttribute("", "",RequestAttributes.SCOPE_REQUEST);
		
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {}

}
