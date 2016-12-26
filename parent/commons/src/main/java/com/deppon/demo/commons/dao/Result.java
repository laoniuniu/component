/**
 * Project: carriage-commons
 * 
 * File Created at 2012-11-9
 * $Id$
 * 
 * Copyright 2012 500mi.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * balunche Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with 500mi.com.
 */
package com.deppon.demo.commons.dao;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.deppon.demo.commons.model.ErrorResult;

/**
 * 支持分页
 * 
 * @author JETLEE
 * 
 */
public class Result<T> extends ErrorResult implements Serializable {
	
	private static final long	serialVersionUID	= -8722768053248374040L;

	private boolean			success				= true;
	private T				data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public void setError(int code,String name,String message){
		super.setError(code, name, message);
		this.setSuccess(false);
	}
}
