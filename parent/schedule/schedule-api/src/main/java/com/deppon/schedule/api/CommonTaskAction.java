package com.deppon.schedule.api;

import com.deppon.schedule.common.Result;
import com.deppon.schedule.model.ScheduleItem;

public interface CommonTaskAction {
	
	public String getActionType();
	
	public Result<Void> execute(ScheduleItem task);
	
}
