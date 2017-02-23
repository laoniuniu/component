package com.ddbschedule.service;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;

public class TestSchedule {
	public static void main(String args[]) throws Exception{
		//new ClassPathXmlApplicationContext("classpath:spring/applicationContext-schedule.xml");
		 // 初始化Spring
        //ApplicationContext ctx = new FileSystemXmlApplicationContext(
          //      "classpath:spring/applicationContext-schedule.xml");

        // 初始化调度工厂
//        TBScheduleManagerFactory scheduleManagerFactory = new TBScheduleManagerFactory();
//
//        Properties p = new Properties();
//        p.put("zkConnectString", "localhost:2181");
//        p.put("rootPath", "/tbSchedule/Test");
//        p.put("zkSessionTimeout", "60000");
//        p.put("userName", "zookeeper");
//        p.put("password", "zookeeper");
//        p.put("isCheckParentPath", "true");
//
//        scheduleManagerFactory.setApplicationContext(ctx);
//        
//        scheduleManagerFactory.init(p);  
    }
}
