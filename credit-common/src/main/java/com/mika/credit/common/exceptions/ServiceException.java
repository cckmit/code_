package com.mika.credit.common.exceptions;

/**
 * 业务异常基类，所有业务异常都必须继承于此异常
 * 
 * @author mika
 *
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -5875371379845226068L;

	/**
	 * 数据库操作,insert返回0
	 */
	public static final ServiceException DB_INSERT_RESULT_0 = new ServiceException(90040001, "数据库操作,insert返回0");

	/**
	 * 数据库操作,update返回0
	 */
	public static final ServiceException DB_UPDATE_RESULT_0 = new ServiceException(90040002, "数据库操作,update返回0");

	/**
	 * 数据库操作,selectOne返回null
	 */
	public static final ServiceException DB_SELECTONE_IS_NULL = new ServiceException(90040003, "数据库操作,selectOne返回null");

	/**
	 * 数据库操作,list返回null
	 */
	public static final ServiceException DB_LIST_IS_NULL = new ServiceException(90040004, "数据库操作,list返回null");

	/**
	 * Token 验证不通过
	 */
	public static final ServiceException TOKEN_IS_ILLICIT = new ServiceException(90040005, "Token 验证非法");
	/**
	 * 会话超时　获取session时，如果是空，throws 下面这个异常 拦截器会拦截爆会话超时页面
	 */
	public static final ServiceException SESSION_IS_OUT_TIME = new ServiceException(90040006, "会话超时");

	/**
	 * 获取序列出错
	 */
	public static final ServiceException DB_GET_SEQ_NEXT_VALUE_ERROR = new ServiceException(90040007, "获取序列出错");

	/**
	 * 异常信息
	 */
	protected String msg;

	/**
	 * 具体异常码
	 */
	protected int code;

	public ServiceException(int code, String msgFormat, Object... args) {
		super(String.format(msgFormat, args));
		this.code = code;
		this.msg = String.format(msgFormat, args);
	}

	public ServiceException() {
		super();
	}

	public String getMsg() {
		return msg;
	}

	public int getCode() {
		return code;
	}

	/**
	 * 实例化异常
	 *
	 * @param msgFormat
	 * @param args
	 * @return
	 */
	public ServiceException newInstance(String msgFormat, Object... args) {
		return new ServiceException(this.code, msgFormat, args);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message) {
		super(message);
	}
}
