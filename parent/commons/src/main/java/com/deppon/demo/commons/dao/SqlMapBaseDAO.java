/**
 * Project: carriage-commons
 * 
 * File Created at 2012-11-10
 * SqlMapBaseDAO
 * 
 * Copyright 2012 500mi.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * balunche Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with 500mi.com.
 */
package com.deppon.demo.commons.dao;

import java.util.List;

import com.deppon.demo.commons.dao.exception.DAOException;


/**
 * SqlmapBaseDAO
 * @author JETLEE
 *
 */
public class SqlMapBaseDAO extends AbstractBaseDAO{

		protected int insert(String statement) throws DAOException{
			return super.getSqlSessionTemplate().insert(statement);
		}
		
		protected int update(String statement) throws DAOException{
			return super.getSqlSessionTemplate().update(statement);
		}
		
		protected List<?> queryForList(String statement,Object parameter) throws DAOException{
			return super.getSqlSessionTemplate().selectList(statement, parameter);
		}
		
		protected Object queryForObject(String statement,Object parameter) throws DAOException{
			return super.getSqlSessionTemplate().selectOne(statement, parameter);
		}
    
    
}
