package com.deppon.dubbo.provider.service;

import java.util.List;


import org.springframework.stereotype.Component;

import com.deppon.demo.commons.dao.Result;
import com.deppon.demo.commons.dao.ResultList;
import com.deppon.dubbo.client.api.DubboDemoService;
import com.deppon.dubbo.client.model.DemoDO;

@Component("dubboDemoService")
public class DubboDemoServiceImpl implements DubboDemoService {
	
/*
	@Resource
	private DemoDao demoDao;
	*/
	
	@Override
	public Result<Integer> insertService(DemoDO demoDO) {
		Result<Integer> result = new Result<Integer>();
		result.setData(1);
		return result;
	}

	@Override
	public Result<Integer> deleteService(DemoDO demoDO) {
		Result<Integer> result = new Result<Integer>();
		result.setData(1);
		return result;
	}

	@Override
	public Result<Integer> updateService(DemoDO demoDO) {
		Result<Integer> result = new Result<Integer>();
		result.setData(1);
		return result;
	}

	@Override
	public ResultList<DemoDO> selectService(DemoDO demoDO) {
		ResultList<DemoDO> result = new ResultList<DemoDO>();
		DemoDO demoDo = new DemoDO();
		demoDo.settLongtext("你好!");
		result.setData(demoDo);
		return result;
	}

}
