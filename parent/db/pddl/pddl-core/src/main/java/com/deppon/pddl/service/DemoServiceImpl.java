package com.deppon.pddl.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.deppon.demo.commons.dao.Result;
import com.deppon.demo.commons.dao.ResultList;
import com.deppon.pddl.client.api.DemoService;
import com.deppon.pddl.client.model.DemoDO;
import com.deppon.pddl.dao.DemoDao;

/**
  * @Title
  * @author <a href="mailto:liulizheng@deppon.com">267452</a>
  * @version 1.0  
  * @date 2017年1月5日 下午2:34:30
 */
@Component("demoService")
public class DemoServiceImpl implements DemoService {
	
	@Resource
	private DemoDao demoDao;
	
	@Override
	public Result<Integer> insertService(DemoDO demoDO) {
		Result<Integer> result = new Result<Integer>();
		Integer rows = demoDao.insert(demoDO);
		result.setData(rows);
		return result;
	}

	@Override
	public Result<Integer> deleteService(DemoDO demoDO) {
		Result<Integer> result = new Result<Integer>();
		Integer rows = demoDao.deleteByPrimaryKey(demoDO.getId());
		result.setData(rows);
		return result;
	}

	@Override
	public Result<Integer> updateService(DemoDO demoDO) {
		Result<Integer> result = new Result<Integer>();
		Integer rows = demoDao.updateByPrimaryKey(demoDO);
		result.setData(rows);
		return result;
	}

	@Override
	public ResultList<DemoDO> selectService(DemoDO demoDO) {
		ResultList<DemoDO> result = new ResultList<DemoDO>();
		DemoDO demoDo = demoDao.selectByPrimaryKey(demoDO.getId());
		result.setData(demoDo);
		return result;
	}

}
