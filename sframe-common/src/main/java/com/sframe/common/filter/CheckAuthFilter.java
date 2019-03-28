package com.sframe.common.filter;

import com.alibaba.fastjson.JSONObject;
import com.sframe.common.ConstantClazz;
import com.sframe.common.model.SessionUserInfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @Author c.9u@outlook.com
 * @Description  权限过滤
 * @Date 15:34 2018/11/17
 * @Param
 * @return
 **/

public class CheckAuthFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(CheckAuthFilter.class);


	/**
	 * 不需要过滤的url
	 */
	private String  unfilterurl;
	/**
	 * 不需要过滤的url集合
	 */
	private String  unfiltersUrlArray[];


	public void init(FilterConfig filterConfig) throws ServletException {

		unfilterurl = filterConfig.getInitParameter("unfilterurl");
		unfiltersUrlArray = unfilterurl.split(";");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String servletPath = req.getServletPath();

			JSONObject  respJson = new JSONObject();
			try {
				if(isUrlinArray(unfiltersUrlArray, servletPath)){	/** 不做拦截的URL*/
					chain.doFilter(request, response);
					return;
				} else {
					/** 需登录才能访问的URL */
					SessionUserInfo sessionUserInfo = (SessionUserInfo) session.getAttribute(ConstantClazz.USER_SESSION_INFO);
					if(null == sessionUserInfo) {	//未登录
						log.error("当前session:"+session.getId()+",未通过登录验证，url:"+servletPath);
						respJson.put("code", ConstantClazz.AUTH_ERROR_LOGIN_CODE);
						this.error(resp, respJson);
					}else {        //根据登录角色判断权限
						chain.doFilter(request, response);
					}
				}
			} catch (Exception e) {
				respJson.put("code", ConstantClazz.ERROR_CODE);
				if(null != e.getCause() && null != e.getCause().getStackTrace()) {
					respJson.put("message", e.getMessage()+","+e.getCause().getStackTrace()[0].getFileName()+e.getCause().getStackTrace()[0].getLineNumber());
				}else {
					respJson.put("message", e.getMessage());
				}
				this.error(resp, respJson);
			}
	}

	public void error(HttpServletResponse resp,JSONObject  respJson) throws IOException {
		log.info("Filter Result："+respJson.toJSONString());
		PrintWriter  writer = resp.getWriter();
		writer.print(JSONObject.toJSONString(respJson));
		writer.flush();
		writer.close();
	}

	@Override
	public void destroy() {
		unfilterurl = null;
		unfiltersUrlArray = null;
	}

	private boolean isUrlinArray(String urlArray[], String url) {
		if (urlArray == null || urlArray.length == 0) {
			return false;
		}
		String urlArrayItem = null;
		for (int i = 0; i < urlArray.length; i++) {
			urlArrayItem = urlArray[i];
			if (urlArrayItem == null) {
				continue;
			}
			if (StringUtils.equals(urlArrayItem.trim(), url)) {
				return true;
			}
		}
		return false;
	}
}
