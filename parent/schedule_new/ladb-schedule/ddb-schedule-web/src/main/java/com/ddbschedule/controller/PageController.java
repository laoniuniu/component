package com.ddbschedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 页面跳转controller
 * <p>Title: PageController</p>
 * <p>@Description:TODO</p>
 * <p>Company: www.chenhaitao.com</p>	
 * @author chenhaitao
 * @date:2017年2月17日下午3:58:28
 * @version:1.0
 */
@Controller
public class PageController {
	@Autowired
	/**
	 * 打开首页
	 */
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	
	
}
