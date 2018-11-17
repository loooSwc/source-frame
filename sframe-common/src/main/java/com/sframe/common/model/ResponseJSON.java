package com.sframe.common.model;

/**
 * @Author c.9u@outlook.com
 * @Description  返回结果json
 * @Date 17:37 2018/11/17
 * @Param
 * @return
 **/
public class ResponseJSON {
	private Object data;
	private String code;
	private String message;


	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
