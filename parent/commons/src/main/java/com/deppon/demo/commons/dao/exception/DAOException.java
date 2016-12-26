/**
 * Project: carriage-commons
 * 
 * File Created at 2012-11-9
 * DAOException
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
package com.deppon.demo.commons.dao.exception;

/**
 * TODO Comment of DAOException
 * @author JETLEE
 *
 */
public class DAOException extends Exception{

	private static final long	serialVersionUID	= 5267921499565103690L;
	
	public DAOException() {
		super();
	}

	public DAOException(String msg) {
		super(msg);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

	public DAOException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
