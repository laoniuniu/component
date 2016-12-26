package com.deppon.demo.commons.util;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * 日期转化工具类
 *
 * @author <a href="mailto:yihui#500mi.com">yihui</a>
 * @version 1.0
 * @since 2015年6月13日
 */
public class DateUtils {
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

	/**
	 * 取得某日期时间的特定表示格式的字符串
	 * 
	 * @param format 
	 *            时间格式
	 * @param date
	 *            某日期（Date）
	 * @return 某日期的字符串 123
	 */
	public static synchronized String getDate2Str(String format, Date date) {
		if (date == null) {
			return "";
		}
		simpleDateFormat.applyPattern(format);
		return simpleDateFormat.format(date);
	}

	/**
	 * 将特定格式的时间字符串转化为Date类型
	 * 
	 * @param format
	 *            时间格式
	 * @param str
	 *            某日期的字符串
	 * @return 某日期（Date）
	 */
	private static synchronized Date getStrToDate(String format, String str) {
		simpleDateFormat.applyPattern(format);
		ParsePosition parseposition = new ParsePosition(0);
		return simpleDateFormat.parse(str, parseposition);
	}

	/**
	 * 将日期转换为长字符串（包含：年-月-日 时:分:秒）
	 * 
	 * @param date
	 *            日期
	 * @return 返回型如：yyyy-MM-dd HH:mm:ss 的字符串
	 */
	public static String getDate2SStr(Date date) {
		return getDate2Str("yyyy-MM-dd HH:mm:ss", date);
	}

	public static String getDate2ymdStr(Date date) {
		if (date == null) {
			return "";
		}
		return getDate2Str("yyyy-MM-dd", date);
	}

	public static String getDate2yymmddStr(Date date) {
		if (date == null) {
			return "";
		}
		return getDate2Str("yyyyMMdd", date);
	}

	/**
	 * 将某指定的字符串转换为型如：yyyy-MM-dd HH:mm:ss的时间
	 * 
	 * @param str
	 *            将被转换为Date的字符串
	 * @return 转换后的Date
	 */
	public static Date getStr2SDate(String str) {
		return getStrToDate("yyyy-MM-dd HH:mm:ss", str);
	}

	/**
	 * 设置日志的默认时间，本函数是返回默认时间= 23:59:59 if(para==null) return null
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String getDateTime2Right(String str) throws Exception {
		str += " 23:59:59";
		if (!isDateTime(str))
			throw new Exception("para is error~");

		return str;
	}

	/**
	 * 检测字符串是否为日期
	 * 
	 * @param date
	 * @param pattern
	 *            Eg "yyyy-MM-dd"
	 * @return
	 */
	private static boolean isDateTime(String dateTime) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		ParsePosition pos = new ParsePosition(0);
		Date dt = df.parse(dateTime, pos);

		if (dt == null)
			return false;
		return true;
	}
	

    //-----------------------------------------------------------------------
    /**
     * Adds a number of years to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addYears(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of months to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addMonths(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of weeks to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addWeeks(Date date, int amount) {
        return add(date, Calendar.WEEK_OF_YEAR, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of days to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of hours to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addHours(Date date, int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of minutes to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addMinutes(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of seconds to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addSeconds(Date date, int amount) {
        return add(date, Calendar.SECOND, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of milliseconds to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addMilliseconds(Date date, int amount) {
        return add(date, Calendar.MILLISECOND, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param calendarField  the calendar field to add to
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    private static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }
    

	public static void main(String args[]) {
		Date date = DateUtils.addYears(new Date(), -1);
		System.out.print(date);
	}

	public static String convert(Date date, String dateFormat) {
		if (date == null) {
			return null;
		}
		if (null == dateFormat) {
			dateFormat = "yyyy-MM-dd HH:mm:ss";
		}
		return new SimpleDateFormat(dateFormat).format(date);
	}
}

