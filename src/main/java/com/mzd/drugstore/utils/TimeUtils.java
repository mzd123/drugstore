package com.mzd.drugstore.utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    public static String MMddHHmmssSSS = "MMddHHmmssSSS";
    public static String yyyy_MM_dd = "yyyy-MM-dd";
    public static String yyyy1MM1dd1 = "yyyy/MM/dd/";
    public static String defaulttime = "yyyy-MM-dd HH:mm:ss";
    public static String HH0mm0ss = "HH:mm:ss";
    public static String yyyyMMddHHmmss = "yyyyMMddHHmmss";

    /**
     * 获取当前时间格式为:yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String get_current_time() {
        return formatDateByFormat(new Date(), defaulttime);
    }

    /**
     * 将日期转换为自己指定的格式
     *
     * @param date   日期
     * @param format 自己指定的日期格式
     * @return 自己指定格式的日期字符串
     */
    public static String formatDateByFormat(Date date, String format) {
        String result = "";
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            result = sdf.format(date);
        }
        return result;
    }

    /**
     * 将日期转换为yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String format_DefaultDate(Date date) {
        return formatDateByFormat(date, defaulttime);
    }

    /**
     * 将日期转换为yyyy/MM/dd/
     *
     * @param date
     * @return
     */
    public static String format_yyyy1MM1dd1(Date date) {
        return formatDateByFormat(date, yyyy1MM1dd1);
    }

    /**
     * 将日期转换为yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String format_yyyy_MM_dd(Date date) {
        return formatDateByFormat(date, yyyy_MM_dd);
    }

    /**
     * 将日期转换为HH0mm0ss
     *
     * @param date
     * @return
     */
    public static String format_HH0mm0ss(Date date) {
        return formatDateByFormat(date, HH0mm0ss);
    }

    /**
     * 将日期转换为yyyyMMddHHmmss
     *
     * @param date
     * @return
     */
    public static String format_yyyyMMddHHmmss(Date date) {
        return formatDateByFormat(date, yyyyMMddHHmmss);
    }

    /**
     * 将日期转换为MMddHHmmssSSS
     *
     * @param date
     * @return
     */
    public static String format_MMddHHmmssSSS(Date date) {
        return formatDateByFormat(date, MMddHHmmssSSS);
    }

    /**
     * 将字符串转化为自己指定的日期格式
     *
     * @param strDate 字符串
     * @param pattern 日期格式
     * @return
     */
    public static Date parseDate(String strDate, String pattern) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date nowDate = format.parse(strDate);
        return nowDate;
    }

    /**
     * 将字符串转换为yyyy_MM_dd格式的时间
     *
     * @param date 日期字符串
     * @return
     */
    public static Date parse_yyyy_MM_dd(String date) throws Exception {
        return parseDate(date, yyyy_MM_dd);
    }

    /**
     * 将字符串转换为defaulttime格式的时间
     *
     * @param date 日期字符串
     * @return
     */
    public static Date parse_defaulttime(String date) throws Exception {
        return parseDate(date, defaulttime);
    }

    /**
     * 获得当前时间，从1970 年 1 月 1 日的 00:00:00.000到现在的毫秒数
     *
     * @return
     */
    public static Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 获取年份
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    /**
     * 获取月份
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取星期
     *
     * @param date
     * @return
     */
    public static int getWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        dayOfWeek = dayOfWeek - 1;
        if (dayOfWeek == 0) {
            dayOfWeek = 7;
        }
        return dayOfWeek;
    }

    /**
     * 获取日期(多少号)--没有年月
     *
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前时间(小时)
     *
     * @param date
     * @return
     */
    public static int getHour(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取当前时间(分)
     *
     * @param date
     * @return
     */
    public static int getMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    /**
     * 获取当前时间(秒)
     *
     * @param date
     * @return
     */
    public static int getSecond(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.SECOND);
    }

    /**
     * 获取当前毫秒
     *
     * @param date
     * @return
     */
    public static long getMillis(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     * 在date的基础上增加几天
     *
     * @param date Date
     * @param day  增加的天数
     * @return Date
     */
    public static Date addDate(Date date, int day) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
        return c.getTime();
    }

    /**
     * 日期相减(返回天数)
     *
     * @param date  Date
     * @param date1 Date
     * @return int 相差的天数
     */
    public static int diffDate(Date date, Date date1) {
        return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
    }

    /**
     * 日期相减(返回秒值)
     *
     * @param date  Date
     * @param date1 Date
     * @return int
     * @author
     */
    public static Long diffDateTime(Date date, Date date1) {
        return (Long) ((getMillis(date) - getMillis(date1)) / 1000);
    }


    /**
     * 可用于id
     *
     * @return
     */
    public static String get_id() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String str = sdf.format(d);
        String haomiao = String.valueOf(System.nanoTime());
        System.out.println(haomiao);
        str = str + haomiao.substring(haomiao.length() - 6, haomiao.length());
        return str;
    }

    /**
     * 获取任意一天的这一周的最后一天
     *
     * @param seday
     */
    public String getLastDayOfWeek(String seday) {
        String var4 = "";
        if (StringUtils.isEmpty(seday)) {
            seday = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
        }
        try {
            SimpleDateFormat var1 = new SimpleDateFormat("yyyy-MM-dd");
            Calendar var2 = Calendar.getInstance();
            var2.setFirstDayOfWeek(2);
            var2.setTime(var1.parse(seday));
            var2.set(7, var2.getFirstDayOfWeek() + 6);
            Timestamp var3 = new Timestamp(var2.getTime().getTime());
            var4 = var3.toString().substring(0, 4) + "-" + var3.toString().substring(5, 7) + "-" + var3.toString().substring(8, 10);
        } catch (Exception var5) {

        }
        return var4;
    }

    /**
     * 获取任意一天的一周开始一天
     *
     * @param seday
     * @return
     */
    public String getFirstDayofWeek(String seday) {
        String var4 = "";
        if (StringUtils.isEmpty(seday)) {
            seday = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
        }
        try {
            SimpleDateFormat var1 = new SimpleDateFormat("yyyy-MM-dd");
            Calendar var2 = Calendar.getInstance();
            var2.setFirstDayOfWeek(2);
            var2.setTime(var1.parse(seday));
            var2.set(7, var2.getFirstDayOfWeek());
            Timestamp var3 = new Timestamp(var2.getTime().getTime());
            var4 = var3.toString().substring(0, 4) + "-" + var3.toString().substring(5, 7) + "-" + var3.toString().substring(8, 10);
        } catch (Exception var5) {

        }
        return var4;
    }


}
