package com.deppon.demo.commons.exception;

public class SettlementException /*extends BusinessExcetion*/{

	/**
	 * 序列号
	 *//*
	private static final long serialVersionUID = 959484631147426908L;

	*//**
	 * 空的构造方法
	 *//*
	public SettlementException() {
	}

	*//**
	 * 空的构造方法
	 *//*
	public SettlementException(String errCode) {
		super();
		super.errCode = errCode;
	}

	*//**
	 * 
	 *  动态异常信息
	 *//*
	public SettlementException(String errCode, String msg) {
		super(errCode, msg);
		super.errCode = errCode;
	}

	*//**
	 * 调用其他模块的Exception 可以传入一个BusinessException异常
	 *//*
	public SettlementException(BusinessException e) {
		super();
		super.errCode = e.getErrorCode();
	}
	
	*//**
	 * 有两个参数的构造函数
	 *//*
	public SettlementException(String code, Throwable cause) {
		super(code,cause);
		this.errCode = code;
	}*/


}
