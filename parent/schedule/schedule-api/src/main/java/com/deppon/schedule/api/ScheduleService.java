package com.deppon.schedule.api;

import com.deppon.schedule.model.ScheduleItem;

/**
 * 插入schedule任务项
 *
 * @author <a href="mailto:yihui#500mi.com">yihui</a>
 * @version 1.0
 * @auther yakirChen iamyakirchen@outlook.com  ~^o^~
 * @update 2016.04.20 20:30:30
 * @since 2015年10月13日
 */
public interface ScheduleService {

    /**
     * 插入任务项
     *
     * @param bizId         业务ID
     * @param taskType      任务名称
     * @param errLog        最近一次错误日志
     * @param param         业务参数
     * @param remark        备注信息
     * @param application   应用名称
     * @param nextRetryTime 下次重试时间unix数字
     * @param status        是否可执行
     * @param scheduleItem  入参
     * @author <a href="mailto:yihui@alibaba-inc.com">yihui</a>
     * @version 1.0
     * @since 2015年10月13日
     */
    void addScheduleTask(ScheduleItem scheduleItem);

    /**
     * 取消执行schedule 任务
     *
     * @param bizId
     * @auther yakirChen iamyakirchen@outlook.com  ~^o^~
     */
    void updateScheduleTaskBizStatus(String bizId);

}
