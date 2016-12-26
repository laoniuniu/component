package com.deppon.schedule.constant;

import com.deppon.schedule.common.MEnum;

public class TaskTypeConst extends MEnum<TaskTypeConst> {

    private static final long serialVersionUID = 4792811885459461877L;

    public static final TaskTypeConst ERROR_MSG_RETRY_TASK = (TaskTypeConst) create("ERROR_MSG_RETRY_TASK", (byte) 0, "错误消息重试任务");

    public static final TaskTypeConst PRODUCER_MSG_RETRY_TASK = (TaskTypeConst) create("PRODUCER_MSG_RETRY_TASK", (byte) 1, "MQ重发消息失败重试任务");
}
