package com.deppon.schedule.service;

import com.deppon.schedule.common.Result;
import com.deppon.schedule.dao.ScheduleItemDAO;
import com.deppon.schedule.model.ScheduleItem;
import com.deppon.schedule.model.ScheduleQuery;
import com.deppon.schedule.util.ScheduleDayWeek;
import com.deppon.schedule.util.ScheduleTable;
import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;


public class DelayMsgTransferScheduleTask implements IScheduleTaskDealSingle<ScheduleItem> {
    private static Logger logger = LoggerFactory
            .getLogger(DelayMsgTransferScheduleTask.class);

    private ScheduleItemDAO commonScheduleItemDAO;

    private TransactionTemplate transactionTemplateSchedule;

    @Override
    public List<ScheduleItem> selectTasks(String taskParameter, String ownSign,
                                          int taskItemNum, List<TaskItemDefine> taskItemList,
                                          int eachFetchDataNum) throws Exception {
        ScheduleQuery query = new ScheduleQuery();
        query.setNextRetryTime(System.currentTimeMillis());
        Integer[] taskList = new Integer[taskItemList.size()];
        int i = 0;
        for (TaskItemDefine taskDefine : taskItemList) {
            taskList[i] = Integer.valueOf(taskDefine.getTaskItemId());
            i++;
        }
//		query.setOwnSign(CommonScheduleSystemInfo.ownSign);
        query.setData(taskList);
        query.setPageSize(eachFetchDataNum);
        query.setOrderBy("next_retry_time");
        query.setTaskItemNum(taskItemNum);

        int dayWeek = ScheduleDayWeek.getDayWeek(System.currentTimeMillis());
        int ampm = ScheduleDayWeek.getAmPm();

        int nowTableNum = ScheduleTable.getNum(dayWeek, ampm);
        int delayTableNum = nowTableNum - 1;
        if (delayTableNum == -1) {
            delayTableNum = 13;
        }

        query.setTableNum(delayTableNum);

        List<ScheduleItem> result = commonScheduleItemDAO.selectDelayList(query);
        logger.error("selectTasks delay size :" + result.size());

        if (result == null || result.size() < eachFetchDataNum) {
            //没数据了
            //删除表数据
            int deleteTableNum = nowTableNum + 1;
            if (deleteTableNum == 14) {
                deleteTableNum = 0;
            }
            String tableNum = frontCompWithZore(deleteTableNum, 2);
            commonScheduleItemDAO.deleteBySeparate(tableNum);
        }

        return result;
    }

    @Override
    public Comparator<ScheduleItem> getComparator() {
        return null;
    }

    @Override
    public boolean execute(final ScheduleItem task, String ownSign) throws Exception {
        final Result<Void> result = new Result<Void>();
        int dayWeek = ScheduleDayWeek.getDayWeek(task.getCreateDate().getTime());
        int ampm = ScheduleDayWeek.getAmPm();
        task.setDayWeek(dayWeek);
        task.setAmpm(ampm);
        transactionTemplateSchedule.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {

                try {
                    int i = commonScheduleItemDAO.update2TransferByPrimaryKey(task);
                    if (i != 1) {
                        result.setSuccess(false);
                        result.setErrorMessage("最后更新schedule失败");
                        status.setRollbackOnly();
                        return;
                    }
                    //
                    task.setRemark(task.getRemark() + ",迁移过来的id" + task.getId());
                    task.setCreateDate(new Timestamp(System.currentTimeMillis()));
                    task.setId(null);
                    int dayWeek = ScheduleDayWeek.getDayWeek(task.getCreateDate().getTime());
                    int ampm = ScheduleDayWeek.getAmPm();
                    task.setDayWeek(dayWeek);
                    task.setAmpm(ampm);
                    task.setTableNum(ScheduleTable.getNum(dayWeek, ampm));
                    commonScheduleItemDAO.insert(task);
                } catch (Throwable e) {
                    result.setSuccess(false);
                    result.setErrorMessage(ExceptionUtils.getStackTrace(e));
                    logger.error(ExceptionUtils.getStackTrace(e));
                    status.setRollbackOnly();
                }
            }
        });

        return true;
    }

    private static String frontCompWithZore(int sourceDate, int formatLength) {
        String newString = String.format("%0" + formatLength + "d", sourceDate);
        return newString;
    }

    public void setCommonScheduleItemDAO(ScheduleItemDAO commonScheduleItemDAO) {
        this.commonScheduleItemDAO = commonScheduleItemDAO;
    }


    public void setTransactionTemplateSchedule(TransactionTemplate transactionTemplateSchedule) {
        this.transactionTemplateSchedule = transactionTemplateSchedule;
    }
}
