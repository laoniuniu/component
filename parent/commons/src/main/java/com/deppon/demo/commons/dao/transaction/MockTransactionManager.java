/**
 * Project: carriage-commons
 * 
 * File Created at 2012-11-10
 * MockTransactionManager
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
package com.deppon.demo.commons.dao.transaction;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

/**
 * TODO Comment of MockTransactionManager
 * @author jetlee
 *
 */
public class MockTransactionManager implements PlatformTransactionManager{

	/* (non-Javadoc)
	 * @see org.springframework.transaction.PlatformTransactionManager#commit(org.springframework.transaction.TransactionStatus)
	 */
	public void commit(TransactionStatus status) throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.transaction.PlatformTransactionManager#getTransaction(org.springframework.transaction.TransactionDefinition)
	 */
	public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.transaction.PlatformTransactionManager#rollback(org.springframework.transaction.TransactionStatus)
	 */
	public void rollback(TransactionStatus status) throws TransactionException {
		// TODO Auto-generated method stub
		
	}

}
