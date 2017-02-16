package com.deppon.pddl.schedule.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.cubc.schedule.api.CommonTaskAction;
import com.deppon.cubc.schedule.common.Result;
import com.deppon.cubc.schedule.model.ScheduleItem;
import com.deppon.pddl.schedule.constants.PddlScheduleConstants;

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
