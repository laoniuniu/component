package com.deppon.schedule.constant;

import com.deppon.schedule.common.MEnum;

public class ScheduleStatusConst extends MEnum<ScheduleStatusConst> {

    private static final long serialVersionUID = -841862947902910049L;

    public static final ScheduleStatusConst DEFAULT = (ScheduleStatusConst) create("DEFAULT", (byte) 0, "初始状态");

    public static final ScheduleStatusConst EXECUTE = (ScheduleStatusConst) create("EXECUTE", (byte) 1, "可执行状态");

    public static final ScheduleStatusConst DELETE = (ScheduleStatusConst) create("DELETE", (byte) -1, "删除");

}
