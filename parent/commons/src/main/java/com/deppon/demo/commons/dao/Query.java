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

/**
 * 
 * @author JETLEE
 * 
 */
public class Query<T> extends QueryBase implements Serializable {

	private static final long	serialVersionUID	= 1930382256159908170L;
	private T	data;
	
	private String orderBy;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		if (orderBy != null && !orderBy.isEmpty()) {
			this.orderBy = orderBy;			
		} else {
			this.orderBy = "id";	
		}
	}
}
