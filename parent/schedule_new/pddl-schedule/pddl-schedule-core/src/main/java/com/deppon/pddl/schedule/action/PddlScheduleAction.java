package com.deppon.pddl.schedule.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.pddl.schedule.constants.PddlScheduleConstants;
import com.deppon.pddl.schedule.task.PddlScheduleTask;
import com.deppon.schedule.api.CommonTaskAction;
import com.deppon.schedule.common.Result;
import com.deppon.schedule.model.ScheduleItem;

public class PddlScheduleAction implements CommonTaskAction {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PddlScheduleAction.class);

	@Override
	public String getActionType() {
		return PddlScheduleConstants.PDDL_SCHEDULL_TASKTYPE;
	}

	@Override
	public Result<Void> execute(ScheduleItem scheduleItem) {
		Result<Void> result = new Result<>();
		LOGGER.error("schedule 任务表中参数" + scheduleItem.getParam());
		try {
			LOGGER.error("业务处理");
		} catch (Exception e) {
			result.setErrorMessage(e.getMessage());
			result.setSuccess(Boolean.FALSE);
			LOGGER.error("xxxx任务出错", e);
			return result;
		}
		result.setSuccess(Boolean.TRUE);
		return result;
	}

}
