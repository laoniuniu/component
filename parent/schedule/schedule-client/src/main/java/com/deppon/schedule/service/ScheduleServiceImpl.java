package com.deppon.schedule.service;

import com.deppon.schedule.api.ScheduleService;
import com.deppon.schedule.constant.ScheduleBizStatusConst;
import com.deppon.schedule.dao.ScheduleItemDAO;
import com.deppon.schedule.model.ScheduleItem;
import com.deppon.schedule.util.ScheduleDayWeek;
import com.deppon.schedule.util.ScheduleTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;


public class ScheduleServiceImpl implements ScheduleService {

    private static Logger logger = LoggerFactory
            .getLogger(ScheduleServiceImpl.class);

    private ScheduleItemDAO commonScheduleItemDAO;


    @Override
    public void addScheduleTask(ScheduleItem scheduleItem) {
        ScheduleItem task = new ScheduleItem();
        task.setBizId(scheduleItem.getBizId());
        task.setBizStatus(ScheduleBizStatusConst.DEFAULT.value());
        if (scheduleItem.getNextRetryTime() == null) {
            task.setNextRetryTime(System.currentTimeMillis());
        }else {
            task.setNextRetryTime(scheduleItem.getNextRetryTime());
        }
        task.setErrorLog(scheduleItem.getErrorLog());
        task.setParam(scheduleItem.getParam());
        task.setApplication(scheduleItem.getApplication());
        task.setRemark(scheduleItem.getRemark());
        task.setRetryNums(0);
        task.setTaskType(scheduleItem.getTaskType());
        task.setStatus(scheduleItem.getStatus());
        task.setCreateDate(new Timestamp(System.currentTimeMillis()));
        task.setOwnSign(CommonScheduleSystemInfo.ownSign);
        int dayWeek = ScheduleDayWeek.getDayWeek(System.currentTimeMillis());
        int ampm = ScheduleDayWeek.getAmPm();
        task.setTableNum(ScheduleTable.getNum(dayWeek, ampm));
        logger.info("tableNum:" + ScheduleTable.getNum(dayWeek, ampm) + " | dayWeek: " + dayWeek + " | ampm: " + ampm);
        commonScheduleItemDAO.insert(task);
    }

    /**
     * 取消执行schedule 任务  biz_status
     *
     * @param bizId
     * @auther yakirChen iamyakirchen@outlook.com  ~^o^~
     */
    @Override
    public void updateScheduleTaskBizStatus(String bizId) {

        ScheduleItem record = new ScheduleItem();
        record.setErrorLog("取消执行");
        record.setRemark("取消执行");
        record.setBizStatus(ScheduleBizStatusConst.ERROR.value());
        record.setBizId(bizId);
        commonScheduleItemDAO.update2CancelByBizCode(record);
    }

    public void setCommonScheduleItemDAO(ScheduleItemDAO commonScheduleItemDAO) {
        this.commonScheduleItemDAO = commonScheduleItemDAO;
    }


}
