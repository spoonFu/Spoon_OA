package com.spoon.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类(时间格式yyyy-MM-dd HH:mm:ss)
 *
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月18日 下午8:16:04
 */
public class TimeUtils {
    protected static Logger logger = LoggerFactory.getLogger(TimeUtils.class);

    public static final long DAYTIME = 86400000;

    public static final DateFormat NORMAL_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final DateFormat TOTAL_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    public static final DateFormat NORMAL_FORMAT_Str = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

    public static final DateFormat DAY_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static final DateFormat MONTH_FORMAT = new SimpleDateFormat("yyyy-MM");

    public static final DateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy");

    public static final DateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

    /**
     * 获取当前日期时间字符串
     *
     * @return
     */
    public static String currentDateTimeStr() {
        return NORMAL_FORMAT.format(new Date());
    }

    /**
     * 获取当前日期字符串
     *
     * @return
     */
    public static String currentDateStr() {
        return DAY_FORMAT.format(new Date());
    }

    /**
     * 获取当前时间字符串
     *
     * @return
     */
    public static String currentTimeStr() {
        return TIME_FORMAT.format(new Date());
    }

    /**
     * 取得一天首尾的时间字符串。（yyyy-MM-dd HH:mm:ss）
     *
     * @param year  年
     * @param month 月（1-12）
     * @param day   日（1-31）
     * @return [0]放天首字符串，[1]放天尾字符串。
     */
    public static String[] getInDay(int year, int month, int day) {
        checkPara(year, month, day);
        String strs[] = new String[2];
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day, 0, 0, 0);
        strs[0] = NORMAL_FORMAT.format(cal.getTime());
        cal.setTimeInMillis(cal.getTimeInMillis() + DAYTIME);
        strs[1] = NORMAL_FORMAT.format(cal.getTime());
        return strs;
    }

    /**
     * 取得一月首尾的时间字符串。（yyyy-MM-dd）
     *
     * @param year  年
     * @param month 月（1-12）
     * @return [0]放月首字符串，[1]放月尾字符串。
     */
    public static String[] getInMonth(int year, int month) {
        checkPara(year, month);
        String strs[] = new String[2];
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1, 0, 0, 0);
        strs[0] = DAY_FORMAT.format(cal.getTime());
        cal.set(year, month, 1, 0, 0, 0);
        strs[1] = DAY_FORMAT.format(cal.getTime());
        return strs;
    }

    /**
     * 取得一年首尾的时间字符串。（yyyy-MM）
     *
     * @param year 年
     * @return [0]放年首字符串，[1]放年尾字符串。
     */
    public static String[] getInYear(int year) {
        checkPara(year);
        String strs[] = new String[2];
        Calendar cal = Calendar.getInstance();
        cal.set(year, 0, 1, 0, 0, 0);
        strs[0] = MONTH_FORMAT.format(cal.getTime());
        cal.set(year + 1, 0, 1, 0, 0, 0);
        strs[1] = MONTH_FORMAT.format(cal.getTime());
        return strs;
    }

    /**
     * 取得日时间字符串。（yyyy-MM-dd）
     *
     * @param year  年
     * @param month 月（1-12）
     * @param day   日（1-31）
     * @return 返回指定年月日的日时间字符串。
     */
    public static String getDayStr(int year, int month, int day) {
        checkPara(year, month, day);
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day, 0, 0, 0);
        return DAY_FORMAT.format(cal.getTime());
    }

    /**
     * 取得月时间字符串。（yyyy-MM）
     *
     * @param year  年
     * @param month 月（1-12）
     * @return 返回指定年月的月时间字符串
     */
    public static String getMonthStr(int year, int month) {
        checkPara(year, month);
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1, 0, 0, 0);
        return MONTH_FORMAT.format(cal.getTime());
    }

    /**
     * 取得年时间字符串。（yyyy）
     *
     * @param year 年
     * @return 返回指定年的年时间字符串
     */
    public static String getYearStr(int year) {
        checkPara(year);
        Calendar cal = Calendar.getInstance();
        cal.set(year, 0, 1, 0, 0, 0);
        return YEAR_FORMAT.format(cal.getTime());
    }

    /**
     * 取得时间字符串。（yyyy-MM-dd HH:mm:ss:zzz）
     *
     * @param cal 时间
     * @return 指定毫秒数得到的时间字符串。
     */
    public static String toTotalTimeStr(Calendar cal) {
        if (cal == null) {
            return "";
        }
        return TOTAL_FORMAT.format(cal.getTime());
    }

    /**
     * 取得当前时间字符串（yyyy-MM-dd HH:mm:ss:zzz）
     *
     * @return 指定毫秒数得到的时间字符串。
     */
    public static String toTotalTimeStr() {
        Calendar cal = Calendar.getInstance();
        return TOTAL_FORMAT.format(cal.getTime());
    }

    /**
     * 取得时间字符串。（yyyy-MM-dd HH:mm:ss）
     *
     * @param time 时间（毫秒数）
     * @return 指定毫秒数得到的时间字符串。
     */
    public static String toTimeStr(long time) {
        checkLong(time);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        return NORMAL_FORMAT.format(cal.getTime());
    }

    /**
     * 取得当前时间字符串。（yyyy-MM-dd HH:mm:ss）
     *
     * @return 当前的时间字符串。
     */
    public static String toTimeStr() {
        Calendar cal = Calendar.getInstance();
        return NORMAL_FORMAT.format(cal.getTime());
    }

    /**
     * 取得当前时间字符串(yyyy-MM-dd_HHmmss)
     *
     * @return
     */
    public static String toTimeAllStr() {
        Calendar cal = Calendar.getInstance();
        return NORMAL_FORMAT_Str.format(cal.getTime());
    }

    /**
     * 取得当前时间字符串(yyyy-MM-dd_HHmmss)
     *
     * @return
     */
    public static String toTimeAllStr(Calendar cal) {
        if (cal == null) {
            return "";
        }
        return NORMAL_FORMAT_Str.format(cal.getTime());
    }

    /**
     * 取得时间字符串。（yyyy-MM-dd HH:mm:ss）
     *
     * @param cal
     * @return
     */
    public static String toTimeStr(Calendar cal) {
        if (cal == null) {
            return "";
        }
        return NORMAL_FORMAT.format(cal.getTime());
    }

    /**
     * 取得日时间字符串。（yyyy-MM-dd）
     *
     * @param time 时间（毫秒数）
     * @return 指定时间的日时间字符串。
     */
    public static String toDayStr(long time) {
        checkLong(time);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        return DAY_FORMAT.format(cal.getTime());
    }

    /**
     * 取得日时间字符串。（yyyy-MM-dd）
     *
     * @param cal 时间（毫秒数）
     * @return 指定时间的日时间字符串。
     */
    public static String toDayStr(Calendar cal) {
        if (cal == null) {
            return "";
        }
        return DAY_FORMAT.format(cal.getTime());
    }

    /**
     * 取得当前日时间字符串。（yyyy-MM-dd）
     *
     * @return 当前的日时间字符串。
     */
    public static String toDayStr() {
        Calendar cal = Calendar.getInstance();
        return DAY_FORMAT.format(cal.getTime());
    }

    /**
     * 取得月时间字符串。（yyyy-MM）
     *
     * @param time 时间（毫秒数）
     * @return 指定时间的月时间字符串。
     */
    public static String toMonthStr(long time) {
        checkLong(time);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        return MONTH_FORMAT.format(cal.getTime());
    }

    /**
     * 取得当前月时间字符串。（yyyy-MM）
     *
     * @return 当前的月时间字符串。
     */
    public static String toMonthStr() {
        Calendar cal = Calendar.getInstance();
        return MONTH_FORMAT.format(cal.getTime());
    }

    /**
     * 取得年时间字符串。（yyyy）
     *
     * @param time 时间（毫秒数）
     * @return 指定时间的年时间字符串。
     */
    public static String toYearStr(long time) {
        checkLong(time);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        return YEAR_FORMAT.format(cal.getTime());
    }

    /**
     * 取得当前年时间字符串。（yyyy）
     *
     * @return 当前的年时间字符串。
     */
    public static String toYearStr() {
        Calendar cal = Calendar.getInstance();
        return YEAR_FORMAT.format(cal.getTime());
    }

    /**
     * 由时间字符串取得对应时间的Calendar
     *
     * @param format  时间字符串对应的格式
     * @param timeStr 时间字符串
     * @return 时间字符串对应的Calendar，如果时间字符串与格式不对应，将返回null
     */
    public static Calendar getCalendar(DateFormat format, String timeStr) {
        try {
            Date date = format.parse(timeStr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public static Calendar getCalendar(String timeStr) {
        try {
            Date date = NORMAL_FORMAT.parse(timeStr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 返回当前的时间Calendar Copyright
     *
     * @return
     */
    public static Calendar getCalendar() {
        return getCalendar(NORMAL_FORMAT, toTimeStr());
    }

    /**
     * 返回一年之间的日期.
     *
     * @param year
     * @return
     */
    public static Calendar[] getBetweenYear(int year) {
        checkPara(year);
        Calendar[] result = new Calendar[]{Calendar.getInstance(), Calendar.getInstance()};
        result[0].set(year, 0, 1, 0, 0, 0);
        result[1].set(year + 1, 0, 1, 0, 0, 0);
        return result;
    }

    /**
     * 返回一月之间的日期
     *
     * @param year
     * @param month
     * @return
     */
    public static Calendar[] getBetweenMonth(int year, int month) {
        checkPara(year, month);
        Calendar[] result = new Calendar[]{Calendar.getInstance(), Calendar.getInstance()};
        result[0].set(year, month - 1, 1, 0, 0, 0);
        result[1].set(year, month, 1, 0, 0, 0);
        return result;
    }

    public static Calendar[] getBetweenDay(int year, int month, int day) {
        checkPara(year, month, day);
        Calendar[] result = new Calendar[]{Calendar.getInstance(), Calendar.getInstance()};
        result[0].set(year, month - 1, day, 0, 0, 0);
        result[1].set(year, month - 1, day + 1, 0, 0, 0);
        return result;
    }

    /**
     * @param cal
     * @return
     */
    public static Calendar[] getBetweenDay(Calendar cal) {
        Calendar[] cals = new Calendar[2];
        if (cal == null) {
            cal = Calendar.getInstance();
        }
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DAY_OF_MONTH);
        Calendar begin = Calendar.getInstance();
        begin.set(year, month, date, 0, 0, 0);
        cals[0] = begin;
        Calendar end = Calendar.getInstance();
        end.set(year, month, date, 23, 59, 59);
        // end.add(Calendar.DAY_OF_MONTH, 1);
        cals[1] = end;
        return cals;
    }

    /**
     * 两个时间之差 返回值为几天几小时几分
     *
     * @param beg
     * @param end
     * @return
     */
    public static String getCalendarBySpace(Calendar beg, Calendar end) {
        long space = end.getTime().getTime() - beg.getTime().getTime();
        // System.out.println(space);
        long dtime = 1000 * 3600 * 24; // A day in milliseconds
        long htime = 1000 * 3600;// A hour in milliseconds
        long mtime = 1000 * 60; // A minute in milliseconds
        long stime = 1000;
        int d = (int) (space / dtime);
        int h = (int) (space / htime - (d * 24));
        int m = (int) (space / mtime - 60 * (d * 24 + h));
        int s = (int) (space / stime - 60 * (60 * 24 * d + 60 * h + m));
        if (d > 0) {
            return new StringBuilder("").append(d).append(" ").append(h).append(":").append(m).append(":").append(s).toString();
        } else {
            return new StringBuilder("").append(h).append(":").append(m).append(":").append(s).toString();
        }
    }

    public static boolean isForward(Calendar beg, Calendar end) {
        if (beg == null || end == null) {
            return false;
        }
        if (end.getTime().getTime() - beg.getTime().getTime() >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static java.sql.Date[] getDates(Calendar[] cals) {
        java.sql.Date[] dates = new java.sql.Date[2];
        if (cals == null || cals.length != 2) {
            return dates;
        }
        dates[0] = new java.sql.Date(cals[0].getTimeInMillis());
        dates[1] = new java.sql.Date(cals[1].getTimeInMillis());
        return dates;
    }

    /**
     * @param year
     * @param month
     * @return
     */
    public static int getTotalDayOfMonth(int year, int month) {
        checkPara(year, month);
        int days = 31;
        switch (month) {
            case 2:
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        days = 29;
                        break;
                    }
                } else if (year % 4 == 0) {
                    days = 29;
                    break;
                }
                days = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
        }
        return days;
    }

    private static void checkPara(int year, int month, int day) {
        if (year < 1) {
            throw new RuntimeException("年时间参数错误。");
        }
        if (month < 1 || month > 12) {
            throw new RuntimeException("月时间参数错误。");
        }
        if (day < 1 || day > 31) {
            throw new RuntimeException("日时间参数错误。");
        }
    }

    private static void checkPara(int year, int month) {
        if (year < 1) {
            throw new RuntimeException("年时间参数错误。");
        }
        if (month < 1 || month > 12) {
            throw new RuntimeException("月时间参数错误。");
        }
    }

    private static void checkPara(int year) {
        if (year < 1) {
            throw new RuntimeException("年时间参数错误。");
        }
    }

    private static void checkLong(long time) {
        if (time < 0) {
            throw new RuntimeException("时间参数错误。");
        }
    }

}
