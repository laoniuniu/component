package com.deppon.schedule.service;

import com.deppon.schedule.api.CommonTaskAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskActionManagerFactory
		implements FactoryBean<TaskActionManager>, InitializingBean, ApplicationContextAware {

	/**
	 * logger
	 */
	private Logger logger = LoggerFactory.getLogger(TaskActionManagerFactory.class);
	private ApplicationContext context;
	private TaskActionManager commonTaskActionManager;

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		commonTaskActionManager = new TaskActionManager();
		String[] actionNames = context.getBeanNamesForType(CommonTaskAction.class, true, false);
		Map<String, List<CommonTaskAction>> actionMap = new HashMap<String, List<CommonTaskAction>>();

		if ((actionNames != null) && (actionNames.length > 0)) {
			for (int i = 0; i < actionNames.length; i++) {
				String actionName = actionNames[i];
				CommonTaskAction action = (CommonTaskAction) context.getBean(actionName, CommonTaskAction.class);
				List<CommonTaskAction> taskActionList = actionMap.get(action.getActionType());
				if (taskActionList == null) {
					taskActionList = new ArrayList<CommonTaskAction>();
					actionMap.put(action.getActionType(), taskActionList);
				}
				taskActionList.add(action);
			}
		} else {
			logger.warn("No TaskAction is defined in the spring container");
		}
		commonTaskActionManager.setActions(actionMap);
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.FactoryBean#isSingleton()
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.FactoryBean#getObject()
	 */
	@Override
	public TaskActionManager getObject() throws Exception {
		return commonTaskActionManager;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.FactoryBean#getObjectType()
	 */
	@Override
	public Class<?> getObjectType() {
		return TaskActionManager.class;
	}

}
