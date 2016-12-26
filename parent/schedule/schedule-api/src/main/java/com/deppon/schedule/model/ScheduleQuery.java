package com.deppon.schedule.model;


import com.deppon.schedule.common.Query;

import java.util.Date;

public class ScheduleQuery extends Query<Integer[]> {

    /**
     *
     */
    private static final long serialVersionUID = 7232830439391130704L;

    private Long nextRetryTime;

    private String application;

    private String ownSign;

    private String taskType;

    private Integer taskItemNum;

    private Date createDate;

    private Date preCdate;

    private Integer dayWeek;

    private Integer ampm;

    private Integer tableNum;

    public Integer getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(Integer dayWeek) {
        this.dayWeek = dayWeek;
    }

    public Integer getAmpm() {
        return ampm;
    }

    public void setAmpm(Integer ampm) {
        this.ampm = ampm;
    }

    public Date getPreCdate() {
        return preCdate;
    }

    public void setPreCdate(Date preCdate) {
        this.preCdate = preCdate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getNextRetryTime() {
        return nextRetryTime;
    }

    public void setNextRetryTime(Long nextRetryTime) {
        this.nextRetryTime = nextRetryTime;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getOwnSign() {
        return ownSign;
    }

    public void setOwnSign(String ownSign) {
        this.ownSign = ownSign;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Integer getTaskItemNum() {
        return taskItemNum;
    }

    public void setTaskItemNum(Integer taskItemNum) {
        this.taskItemNum = taskItemNum;
    }

    public Integer getTableNum() {
        return tableNum;
    }

    public void setTableNum(Integer tableNum) {
        this.tableNum = tableNum;
    }
}
