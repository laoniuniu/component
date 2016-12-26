package com.deppon.schedule.service;

import com.deppon.schedule.api.CommonTaskAction;
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

import java.util.Comparator;
import java.util.List;

public class BaseScheduleTask implements IScheduleTaskDealSingle<ScheduleItem> {
    private static Logger logger = LoggerFactory
            .getLogger(BaseScheduleTask.class);

    private ScheduleItemDAO commonScheduleItemDAO;
    private TaskActionManager commonTaskActionManager;

    private TransactionTemplate transactionTemplateSchedule;
    private String taskType;

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
        query.setOwnSign(CommonScheduleSystemInfo.ownSign);
        query.setData(taskList);
        query.setPageSize(eachFetchDataNum);
        query.setOrderBy("next_retry_time");
        query.setTaskItemNum(taskItemNum);
        query.setTaskType(this.getTaskType());
        int dayWeek = ScheduleDayWeek.getDayWeek(System.currentTimeMillis());
        int ampm = ScheduleDayWeek.getAmPm();
        query.setTableNum(ScheduleTable.getNum(dayWeek, ampm));
        List<ScheduleItem> result = commonScheduleItemDAO.selectList(query);

        logger.error("selectTasks size :" + result.size());
        return result;
    }

    @Override
    public Comparator<ScheduleItem> getComparator() {
        return null;
    }

    @Override
    public boolean execute(final ScheduleItem task, String ownSign) throws Exception {
        final Result<Void> result = new Result<Void>();
        logger.error(task.getBizId() + ":" + task.getTaskType() + ":" + task.getBizStatus() + ":" + CommonScheduleSystemInfo.ownSign);

        final List<CommonTaskAction> taskActions = commonTaskActionManager.getTaskAction(task.getTaskType());
        if (taskActions == null || taskActions.size() == 0) {
            logger.error("taskActions==null||taskActions.size()==0");
            return false;
        }
        transactionTemplateSchedule.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {

                try {

                    for (CommonTaskAction taskAction : taskActions) {
                        Result<Void> taskExecuteRs = taskAction.execute(task);
                        if (!taskExecuteRs.isSuccess()) {
                            result.setSuccess(false);
                            result.setErrorMessage(taskAction.getActionType() + "执行失败: " + taskExecuteRs.getErrorCode() + "," + taskExecuteRs.getErrorName() + "," + taskExecuteRs.getErrorMessage());
                            status.setRollbackOnly();
                            return;
                        }
                    }
                    int i = commonScheduleItemDAO.update2SucessByPrimaryKey(task);
                    if (i != 1) {
                        result.setSuccess(false);
                        result.setErrorMessage("最后更新schedule失败");
                        status.setRollbackOnly();
                        return;
                    }
                } catch (Throwable e) {
                    result.setSuccess(false);
                    result.setErrorMessage(ExceptionUtils.getStackTrace(e));
                    logger.error(ExceptionUtils.getStackTrace(e));
                    status.setRollbackOnly();
                }
            }
        });

        if (!result.isSuccess()) {
            task.setNextRetryTime(System.currentTimeMillis() + (1000 * 60 * (task.getRetryNums() + 1)));
            task.setErrorLog(result.getErrorMessage().substring(0, result.getErrorMessage().length() > 2048 ? 2048 : result.getErrorMessage().length()));
            int i = commonScheduleItemDAO.update2RetryByPrimaryKey(task);
            if (i != 1) {
                logger.error("设置重试失败：task.bid:" + task.getBizId() + ",task.id:" + task.getId());
                return false;
            }
        }
        return true;
    }

    public void setCommonScheduleItemDAO(ScheduleItemDAO commonScheduleItemDAO) {
        this.commonScheduleItemDAO = commonScheduleItemDAO;
    }

    public void setCommonTaskActionManager(TaskActionManager commonTaskActionManager) {
        this.commonTaskActionManager = commonTaskActionManager;
    }

    public void setTransactionTemplateSchedule(TransactionTemplate transactionTemplateSchedule) {
        this.transactionTemplateSchedule = transactionTemplateSchedule;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
}
