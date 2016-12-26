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

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * TODO Comment of AbstractBaseDAO
 * @author JETLEE
 *
 */
public abstract class AbstractBaseDAO extends SqlSessionDaoSupport{
	public SqlSessionTemplate getSqlSessionTemplate() {
		  return (SqlSessionTemplate)super.getSqlSession();
	}
}
