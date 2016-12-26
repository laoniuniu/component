package com.deppon.schedule.constant;


import com.deppon.schedule.common.MEnum;

public class ScheduleBizStatusConst extends MEnum<ScheduleBizStatusConst> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final ScheduleBizStatusConst DEFAULT =(ScheduleBizStatusConst) create("DEFAULT", 0,  "未处理");

	public static final ScheduleBizStatusConst SUCCESS =(ScheduleBizStatusConst) create("INITIALIZE", 1,  "成功");
	
	public static final ScheduleBizStatusConst RETRY =(ScheduleBizStatusConst) create("RETRY", 2,  "失败需要重试");
	
	public static final ScheduleBizStatusConst ERROR =(ScheduleBizStatusConst) create("ERROR", 3,  "失败不需要重试");
	
}
