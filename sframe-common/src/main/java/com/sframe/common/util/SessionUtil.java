package com.sframe.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @Author cxy@acmtc.com
 * @Description  Session工具
 * @Date 17:17 2018/11/22
 * @Param
 * @return
 **/
public class SessionUtil {

	public static HttpServletRequest getRequest() {
		return getRequest(true);
	}

	public static HttpServletRequest getRequest(boolean throwExceptionIfNull) {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if(servletRequestAttributes == null ){
			if(throwExceptionIfNull){
				throw new RuntimeException("无法获取http request,请确保在servlet线程中执行,并配置 org.springframework.web.context.request.RequestContextListener");
			}else{
				return null;
			}
		}
		HttpServletRequest request = servletRequestAttributes.getRequest();
		if(throwExceptionIfNull && request == null){
			throw new RuntimeException("无法获取http request,请确保在servlet线程中执行,并配置 org.springframework.web.context.request.RequestContextListener");
		}
		
		return request;
	}
	
	public static HttpSession getSession() {
		HttpServletRequest httpServletRequest = getRequest(false);
		if(httpServletRequest == null){
			return null;
		}else{
			return httpServletRequest.getSession();
		}
	}
	
}
