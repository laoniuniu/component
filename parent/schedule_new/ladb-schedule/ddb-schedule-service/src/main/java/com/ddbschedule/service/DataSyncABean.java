package com.ddbschedule.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.ddbschedule.pojo.TbUser;
import com.ddbschedule.service.CopyService;
import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
@Service("dataSyncABean")
public class DataSyncABean implements IScheduleTaskDealSingle<TbUser>{

	@Autowired
	private CopyService copyService;
	private TbUser user;
	@Override
	public List<TbUser> selectTasks(String taskParameter, String ownSign, int taskItemNum,
			List<TaskItemDefine> taskItemList, int eachFetchDataNum) throws Exception {
		List<TbUser> result = new ArrayList<TbUser>();
        if (taskItemList.size() == 0) {
            return result;
        }
        StringBuffer condition = new StringBuffer();
        for (int i = 0; i < taskItemList.size(); i++) {
            if (i > 0) {
                condition.append(",");
            }
            condition.append(taskItemList.get(i).getTaskItemId());
        }
        /*从T_USER表中取出数据*/
        user = copyService.getUser(9);
        System.out.println("选择任务列表" + new Date());
//        TbUser user = new TbUser();
//        user.setId((long) 1);
        result.add(user);
        return result;
	}

	@Override
	public Comparator<TbUser> getComparator() {
		return null;
	}

	@Override
	public boolean execute(TbUser task, String ownSign) throws Exception {
		//将T_USER取出的数据存放到T_USER_COPY
		int insertUser = copyService.insertUser(user);
		System.out.println(insertUser);
		System.out.println("任务开始" + new Date());
		return true;
	}

}
