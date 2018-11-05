package com.sframe.common.exception;



@SuppressWarnings("serial")
public class AppException extends RuntimeException {
	private String ErrorMessage = null;

	private String[] argsMessage = null;

	private Throwable myException;
	
	private String[] originMessage = null;

	/**
	 * @param msg
	 */
	public AppException(String msg) {
		this(msg, null,null);
	}

	/**
	 * 
	 * @param msg
	 * @param args
	 */
	public AppException(String msg, String[] args) {
		/**
         *传入带BOSS名称的异常,String数组长度为3 如：
         *throw (new AppException("error.boss.message", new String[] {   
	     *result, (String) output.get("SVC_ERR_MSG32"),"s5584PhoneCallWS" })) 
         */
		this(msg, null, args);
	}

	/**
	 * @param msg
	 * @param ex
	 */
	public AppException(String msg, Throwable ex) {
		this(msg,ex,null);
	}

	/**
	 * 
	 * @param msg
	 * @param ex
	 * @param args
	 */
	public AppException(String msg, Throwable ex, String[] args) {
		super(msg);
	}

	/**
	 * @return java.lang.String
	 */
	public String getErrorMessage() {
		return ErrorMessage;
	}

	/**
	 * @return java.lang.Throwable
	 */
	public Throwable getMyException() {
		return myException;
	}

	public String[] getArgsMessage() {
		return argsMessage;
	}

	public String[] getOriginMessage() {
		return originMessage;
	}
	
}
