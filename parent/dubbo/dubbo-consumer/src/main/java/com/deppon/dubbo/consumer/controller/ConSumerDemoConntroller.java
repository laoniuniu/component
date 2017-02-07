package com.deppon.dubbo.consumer.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deppon.demo.commons.dao.Result;
import com.deppon.demo.commons.dao.ResultList;
import com.deppon.dubbo.client.api.DubboDemoService;
import com.deppon.dubbo.client.model.DemoDO;


@Controller
@RequestMapping("/d-con/")
public class ConSumerDemoConntroller {

	@Resource
	private DubboDemoService dubboDemoService;
	
	/**
	 * dubbo insert service
	 * @return
	 */
	@RequestMapping(value="insert")
	@ResponseBody
	public String insertConntroller(DemoDO demoDO) {
		Result<Integer> result = dubboDemoService.insertService(demoDO);
		return "insert id: "+ result.getData();
	}
	/**
	 * dubbo del service
	 * @return
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	public String deleteConntroller(DemoDO demoDO) {
		Result<Integer> result = dubboDemoService.deleteService(demoDO);
		return "delete id: " + result.getData();
	}
	
	/**
	 * dubbo update service
	 * @return
	 */
	@RequestMapping(value="update")
	@ResponseBody
	public String updateConntroller(DemoDO demoDO) {
		Result<Integer> result = dubboDemoService.updateService(demoDO);
		return "update id: " +result.getData();
	}
	
	/**
	 * dubbo select list service
	 * @return
	 */
	@RequestMapping(value="select")
	@ResponseBody
	public String selectConntroller(DemoDO demoDO) {
		ResultList<DemoDO> resList = dubboDemoService.selectService(demoDO);
		return "select body: " + resList.getData().gettVarchar();
	}
	
}
