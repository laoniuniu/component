package com.deppon.schedule.service;

import com.deppon.schedule.api.CommonTaskAction;

import java.util.List;
import java.util.Map;


public class TaskActionManager {
	
	Map<String,List<CommonTaskAction>> taskActions;
	
	public List<CommonTaskAction> getTaskAction(String acitonName){
		return taskActions.get(acitonName);
	}

	public Map<String, List<CommonTaskAction>> getActions() {
		return taskActions;
	}

	public void setActions(Map<String, List<CommonTaskAction>> taskActions) {
		this.taskActions = taskActions;
	}
	
	
}
