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
package com.deppon.demo.commons.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * TODO Comment of BaseDO
 * @author JETLEE
 *
 */
public class BaseDO implements Serializable {

	private static final long	serialVersionUID	= -4067456744885564575L;	
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
