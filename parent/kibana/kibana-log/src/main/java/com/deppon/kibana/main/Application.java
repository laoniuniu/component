package com.deppon.kibana.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class Application {
	 private static final Logger LOGGER = Logger.getLogger(Application.class);
     public Application() {
          // TODO Auto-generated constructor stub
     }
     public static void main(String[] args) {
          // TODO Auto-generated method stub
       for (int i = 0; i < 10; i++) {
           LOGGER.info("Info log [" + i + "].");
           try {
                     Thread.sleep(500);
                } catch (InterruptedException e) {
                     // TODO Auto-generated catch blockl
                     e.printStackTrace();
                }
       }
    	Date date = new Date();
// 		DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.LONG,locale);
 		//String formatDate = dateFormat.format(date);
 		SimpleDateFormat dateFormat2 = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss");
 		
 		String foString = dateFormat2.format(date);
 		LOGGER.info(date);
     }
}
