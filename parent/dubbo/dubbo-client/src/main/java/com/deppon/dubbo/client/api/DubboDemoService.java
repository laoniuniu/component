package com.deppon.dubbo.client.api;

import com.deppon.demo.commons.dao.Result;
import com.deppon.demo.commons.dao.ResultList;
import com.deppon.dubbo.client.model.DemoDO;

/**
  * @Title dubbo demo
  * @author <a href="mailto:liulizheng@deppon.com">267452</a>
  * @version 1.0  
  * @date 2016年12月23日 上午10:00:36
 */
public interface DubboDemoService {
	
	/**
	 * dubbo insert service
	 * @return
	 */
	public Result<Integer> insertService(DemoDO demoDO);
	/**
	 * dubbo del service
	 * @return
	 */
	public Result<Integer> deleteService(DemoDO demoDO);
	
	/**
	 * dubbo update service
	 * @return
	 */
	public Result<Integer> updateService(DemoDO demoDO);
	
	/**
	 * dubbo select list service
	 * @return
	 */
	public ResultList<DemoDO> selectService(DemoDO demoDO);
}
