package com.deppon.pddl.client.api;

import com.deppon.demo.commons.dao.Result;
import com.deppon.demo.commons.dao.ResultList;
import com.deppon.pddl.client.model.DemoDO;

/**
  * @Title
  * @author <a href="mailto:liulizheng@deppon.com">267452</a>
  * @version 1.0  
  * @date 2017年1月5日 下午2:11:18
 */
public interface DemoService {

	/**
	 * insert service
	 * @return
	 */
	public Result<Integer> insertService(DemoDO demoDO);
	/**
	 * del service
	 * @return
	 */
	public Result<Integer> deleteService(DemoDO demoDO);
	
	/**
	 * update service
	 * @return
	 */
	public Result<Integer> updateService(DemoDO demoDO);
	
	/**
	 * select list service
	 * @return
	 */
	public ResultList<DemoDO> selectService(DemoDO demoDO);
}
