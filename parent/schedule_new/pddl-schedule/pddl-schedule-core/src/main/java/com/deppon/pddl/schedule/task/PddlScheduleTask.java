package com.deppon.pddl.schedule.task;

import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.deppon.cubc.schedule.model.ScheduleItem;
import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;

public class PddlScheduleTask implements IScheduleTaskDealSingle<ScheduleItem> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PddlScheduleTask.class);

	@Override
	public List<ScheduleItem> selectTasks(String taskParameter, String ownSign,
			int taskItemNum, List<TaskItemDefine> taskItemList,
			int eachFetchDataNum) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.error("PddlScheduleTask定时任务开始,参数：taskParameter="+taskParameter
    			+",ownSign="+ownSign+",taskItemNum="+taskItemNum+",taskItemList="+JSON.toJSONString(taskItemList));
		
		LOGGER.error("PddlScheduleTask 业务逻辑..");
		
		LOGGER.error("PddlScheduleTask定时任务结束");
		return null;
	}

	@Override
	public Comparator<ScheduleItem> getComparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean execute(ScheduleItem task, String ownSign) throws Exception {
		// TODO Auto-generated method stub
		return Boolean.TRUE;
	}

}
