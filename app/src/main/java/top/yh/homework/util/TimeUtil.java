package top.yh.homework.util;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @user
 * @date
 */
public class TimeUtil {
    /**
     * 获取年月日
     * @return yyyy-MM-dd格式
     */
    public static String getTimeToYearMonthDay() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    public static String getTimeToYearMonth() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("yyyy-MM"));
    }
    public static String getTimeToYearMonthDayHourMinuteSecond(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    public static int getYear(){
        return LocalDateTime.now().getYear();
    }
    public static int getMonth(){
        return LocalDateTime.now().getMonth().getValue();
    }
    public static int getDayOfMonth(){
        return LocalDateTime.now().getDayOfMonth();
    }
}
