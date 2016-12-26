package com.deppon.schedule.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 计算当前时间使用的schedule表
 * <p/>
 * ———————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * |星期 |     周日           |         周一       |        周二         |        周三        |         周四        |       周五           |       周六          |
 * ———————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * |上午0| cu_schedule_item_0 | cu_schedule_item_2 | cu_schedule_item_4 | cu_schedule_item_6 | cu_schedule_item_8 | cu_schedule_item_10 | cu_schedule_item_12 |
 * |——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 * |下午1| cu_schedule_item_1 | cu_schedule_item_3 | cu_schedule_item_5 | cu_schedule_item_7 | cu_schedule_item_9 | cu_schedule_item_12 | cu_schedule_item_14 |
 * ———————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
 *
 * @author <a href="mailto:sanjing@pamirs.top">mitsui</a>
 * @version 1.0
 * @since 2016/11/2
 */
public class ScheduleTable {

    private static Map<String, Integer> TABLEMAPPINT = new HashMap<>();

    static {
        TABLEMAPPINT.put("00", 0);
        TABLEMAPPINT.put("01", 1);
        TABLEMAPPINT.put("10", 2);
        TABLEMAPPINT.put("11", 3);
        TABLEMAPPINT.put("20", 4);
        TABLEMAPPINT.put("21", 5);
        TABLEMAPPINT.put("30", 6);
        TABLEMAPPINT.put("31", 7);
        TABLEMAPPINT.put("40", 8);
        TABLEMAPPINT.put("41", 9);
        TABLEMAPPINT.put("50", 10);
        TABLEMAPPINT.put("51", 11);
        TABLEMAPPINT.put("60", 12);
        TABLEMAPPINT.put("61", 13);
    }

    public static Integer getNum(int dayWeek, int ampm) {
        String key = Integer.toString(dayWeek) + Integer.toString(ampm);
        return TABLEMAPPINT.get(key);
    }

    public static void main(String[] args) {
        System.out.println(getNum(6, 1));
    }
}
