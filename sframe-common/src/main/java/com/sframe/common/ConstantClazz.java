package com.sframe.common;

public class ConstantClazz {
	public static final String MVC_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";// spring
	public static String WEB_PATH = "";         //系统跟路径,Listener初始化赋值

	public static final String USER_SESSION_INFO= "SESSION_USERINFO"; //用户信息session

	public static final int AUTH_ERROR_LOGIN_CODE = 100000; //无权限/未登录

	public final static int ERROR_CODE = 500000;// 错误标识

	public final int BUSINESS_ERROR_CODE = 200000; //业务错误

	/**
	 * 密码加密传输时的Key
	 * 使用场景：
	 * ①、登录
	 * ②、注册
	 * ③、修改密码
	 * ④、重置密码
	 * ⑤、忘记密码重置
	 * 生成：由/user/login/getpasskey.do生成并存储到session中
	 */
	public final static String SYS_SESSION_PASSWORD = "SESSION_PASSKEY";	//密码加密传输Key

	public final static String SYS_SESSION_PASSWORD_REGISTER = "SESSION_PASSKEY_REGISTER";
	public final static String SYS_SESSION_PASSWORD_EDIT = "SESSION_PASSKEY_EDIT";
}
