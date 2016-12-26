package com.deppon.schedule.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ScheduleDayWeek {

    public static int getDayWeek(Long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);


        return dayWeek - 1;
    }

    public static int getAmPm() {
        GregorianCalendar ca = new GregorianCalendar();
        return ca.get(GregorianCalendar.AM_PM);
    }

    public static void main(String[] args) {
        System.out.println(getDayWeek(System.currentTimeMillis()));
        System.out.println("上午/下午：" + getAmPm());
    }
}
