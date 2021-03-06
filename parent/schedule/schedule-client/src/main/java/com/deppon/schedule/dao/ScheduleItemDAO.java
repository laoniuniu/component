package com.deppon.schedule.dao;

import com.deppon.schedule.model.ScheduleItem;
import com.deppon.schedule.model.ScheduleQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ScheduleItemDAO {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mono_schedule_item
     *
     * @mbggenerated Tue Aug 11 22:15:32 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mono_schedule_item
     *
     * @mbggenerated Tue Aug 11 22:15:32 CST 2015
     */
    int insert(ScheduleItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mono_schedule_item
     *
     * @mbggenerated Tue Aug 11 22:15:32 CST 2015
     */
    int insertSelective(ScheduleItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mono_schedule_item
     *
     * @mbggenerated Tue Aug 11 22:15:32 CST 2015
     */
    ScheduleItem selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mono_schedule_item
     *
     * @mbggenerated Tue Aug 11 22:15:32 CST 2015
     */
    int updateByPrimaryKeySelective(ScheduleItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mono_schedule_item
     *
     * @mbggenerated Tue Aug 11 22:15:32 CST 2015
     */
    int updateByPrimaryKey(ScheduleItem record);

    List<ScheduleItem> selectList(ScheduleQuery query);
    
    List<ScheduleItem> selectDelayList(ScheduleQuery query);
    
    int deleteBySeparate(@Param("tableNum")String tableNum);


    int update2SucessByPrimaryKey(ScheduleItem record);
    int update2TransferByPrimaryKey(ScheduleItem record);


    int update2RetryByPrimaryKey(ScheduleItem record);

    /**
     * 取消执行任务 biz_status 置为 3
     *
     * @param record ScheduleItem
     * @return
     * @auther yakirChen iamyakirchen@outlook.com  ~^o^~
     * @date
     */
    int update2CancelByBizCode(ScheduleItem record);


    ScheduleItem selectByBizId(String bizId);


}