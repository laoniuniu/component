package com.deppon.pddl.conntroller;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deppon.demo.commons.dao.Result;
import com.deppon.demo.commons.dao.ResultList;
import com.deppon.pddl.client.api.DemoService;
import com.deppon.pddl.client.model.DemoDO;

@Controller
@RequestMapping("/d-rest/")
public class DemoConntroller {
	
	@Resource
	private DemoService demoSerice;
	
	/**
	 * insert service
	 * @return
	 */
	@RequestMapping(value="insert")
	@ResponseBody
	public String insertConntroller() {
		DemoDO demoDO = new DemoDO();
		demoDO.settDate(new Date());
		demoDO.settDecimal(new BigDecimal(1));
		demoDO.settDouble(1.2);
		demoDO.settEnum("A");
		demoDO.settInt(1);
		demoDO.settVarchar("hahaha");
		Result<Integer> result = demoSerice.insertService(demoDO);
		return "insert id："+ result.getData();
	}
	/**
	 * del service
	 * @return
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	public String deleteConntroller() {
		DemoDO demoDO = new DemoDO();
		demoDO.setId(1L);
		Result<Integer> result = demoSerice.deleteService(demoDO);
		return "delete id：" + result.getData();
	}
	
	/**
	 * update service
	 * @return
	 */
	@RequestMapping(value="update")
	@ResponseBody
	public String updateConntroller() {
		DemoDO demoDO = new DemoDO();
		demoDO.setId(1L);
		demoDO.settDate(new Date());
		Result<Integer> result = demoSerice.updateService(demoDO);
		return "update id：" +result.getData();
	}
	
	/**
	 * select list service
	 * @return
	 */
	@RequestMapping(value="select")
	@ResponseBody
	public String selectConntroller() {
		DemoDO demoDO = new DemoDO();
		demoDO.setId(1L);
		ResultList<DemoDO> resList = demoSerice.selectService(demoDO);
		return "select body：" + resList.getData().gettDate();
	}
	
}
