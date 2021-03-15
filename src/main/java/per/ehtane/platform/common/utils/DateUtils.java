package per.ehtane.platform.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 时间工具类
 *
 * @author sen li
 * @version 1.0.0
 * @date 2021/3/15 15:12
 **/
public class DateUtils {

    /**
     * 日期格式
     */
    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String HHMMSS = "HHmmss";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 当前时间字符串
     * @author sen li
     * @date 2021/3/15 15:16
     * @return java.lang.String 当前时间字符串
    **/
    public static String now(){
        return now(YYYYMMDDHHMMSSSSS);
    }

    /**
     * 指定格斯字符串
     * @author sen li
     * @date 2021/3/15 15:17
     * @param pattern: 日期时间格式
     * @return java.lang.String  指定格式的时间字符串
    **/
    public static String now(String pattern){

        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * yyyyMMddHHmmssSSS格式的时间格式字符串
     * @author sen li
     * @date 2021/3/15 15:19
     * @param dateTime: 时间
     * @return java.lang.String  yyyyMMddHHmmssSSS格式的时间格式字符串
    **/
    public static String format17(LocalDateTime dateTime){
        return dateTime.format(DateTimeFormatter.ofPattern(YYYYMMDDHHMMSSSSS));
    }

    /**
     * 计算两个时间之间的天数
     * @param fromDate 开始日期
     * @param toDate 结束日期
     * @return 两个日期间的天数差
     */
    public static int calculateTwoDays(Date fromDate, Date toDate){
        long to = fromDate.getTime();
        long from = toDate.getTime();
        return (int) ((to - from) / (1000 * 60 * 60 * 24));
    }
}
