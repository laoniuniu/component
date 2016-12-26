package com.deppon.demo.commons.exception;

import com.deppon.demo.commons.model.ErrorResult;

public class ServiceException extends RuntimeException{
	private static final long serialVersionUID = 1427069295488572389L;
	
	private ErrorResult error;
	
	public ServiceException(){
		super();
	}
	
	public ServiceException(int code,String name,String message){
		super("["+name+"]["+code+"]:"+message);
		error = new ErrorResult();
		error.setError(code, name, message);
	}
	
	public ServiceException(String name,String message){
		this(ErrorResult.GENERAL_CODE,name,message);
	}
	
	public ServiceException(String message){
		super(message);
	}
	
	public ServiceException(String message,Throwable cause){
		super(message,cause);
	}
	
	public ServiceException(Throwable cause){
		super(cause);
	}
	
	public ErrorResult getError() {
		return this.error;
	}

	
}
