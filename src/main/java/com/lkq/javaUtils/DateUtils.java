package main.java.com.lkq.javaUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
    public static String yyyy_MM_dd_hh_mm_ss="yyyy-MM-dd hh:mm:ss";
    public static String yyyy_MM_dd_hh_mm="yyyy-MM-dd hh:mm";
    public static String yyyy_MM_dd="yyyy-MM-dd";
    public static String hh_mm_ss="hh:mm:ss";
    public static String hh_mm="hh:mm";

    /**
     *  日期格式转换成字符串
     *  调用例子：
     *  System.out.println(DateUtils.dateToString(new Date(), DateUtils.yyyy_MM_dd));
     *  return：2018-09-16
     */
    public static String dateToString(Date date, String from){
        SimpleDateFormat sdf=new SimpleDateFormat(from);
        String dataString=sdf.format(date);
        return dataString;
    }

    /**
     *判断日期是星期几 (注：星期日是 0)
     * 例子
     * System.out.println(DateUtils.dateIsWeek( "2018-09-17"));
     * return：1
     */
    public static Integer dateIsWeek(String dateStr){
        SimpleDateFormat sdf=new SimpleDateFormat(DateUtils.yyyy_MM_dd);
        Date date=null;
        try {
            date=sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(calendar.DAY_OF_WEEK)-1;
        return day;
    }
    /**
     * 指定 开始日期 到 结束日期 集合
     * 调用例子：
     * System.out.println(DateUtils.startToEndDate( 1, 7));
     * return: [2018-09-17, 2018-09-18, 2018-09-19, 2018-09-20, 2018-09-21, 2018-09-22, 2018-09-23]
     */
    public static List<String> startToEndDate(Integer start, Integer end){
        List<String> dateList=new ArrayList<>();
        for(int i=start;i<=end;i++){
            //Calendar calendar = new GregorianCalendar();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE,i-1);//把日期往后增加一天.整数往后推,负数往前移动
            Date date=calendar.getTime();//这个时间就是日期往后推一天的结果
            SimpleDateFormat sdf=new SimpleDateFormat(DateUtils.yyyy_MM_dd);
            String dataString=sdf.format(date);
            dateList.add(dataString);
        }
        return dateList;
    }

    /**
     * 指定 开始日期 到 结束日期 集合 并判断是属于指定星期的
     * 调用例子：
     * System.out.println(DateUtils.startToEndDateByWeek( 1, 7,"1,2,3,0"));
     * return: [2018-09-16, 2018-09-17, 2018-09-18, 2018-09-19]
     */
    public static List<String> startToEndDateByWeek(Integer start, Integer end,String weeks){
        weeks=weeks.replace("7","0");
        List<String> dateList=new ArrayList<>();
        for(int i=start;i<=end;i++){
            //Calendar calendar = new GregorianCalendar();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE,i-1);//把日期往后增加一天.整数往后推,负数往前移动
            Date date=calendar.getTime();//这个时间就是日期往后推一天的结果
            SimpleDateFormat sdf=new SimpleDateFormat(DateUtils.yyyy_MM_dd);
            String dataString=sdf.format(date);

            int day = calendar.get(calendar.DAY_OF_WEEK)-1;
            if(weeks.indexOf(day+"")!=-1){
                dateList.add(dataString);
            }
        }
        return dateList;
    }

    /**
     * 日期转成数值
     * 调用例子：
     * System.out.println(DateUtils.dateStrToLong("2018-09-19 19:10:00",DateUtils.yyyy_MM_dd_hh_mm_ss));
     * return: 1537286400000
     */
    public static Long dateStrToLong(String dateStr,String format){
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        Date date=null;
        try {
            date=sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long dateLong=date.getTime();
        return dateLong;
    }

    /**
     * 日期转成数值
     * 调用例子：
     * System.out.println(DateUtils.longToDateStr(1537286400000L,DateUtils.yyyy_MM_dd_hh_mm_ss));
     * return: 2018-09-19 12:00:00
     */
    public static String longToDateStr(Long dateLong,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date=new Date(dateLong);
        String dateStr=sdf.format(date);
        return dateStr;
    }

    /**
     * 比较两个日期大小,返回较小值
     * 调用例子：
     *System.out.println(DateUtils.compareDateTakeSmall("2018-09-19","2018-09-15"));
     * return: 2018-09-15
     */
    public static String compareDateTakeSmall(String date1,String date2){
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.yyyy_MM_dd);
        Long long1=dateStrToLong(date1,DateUtils.yyyy_MM_dd);
        Long long2=dateStrToLong(date2,DateUtils.yyyy_MM_dd);
        if(long1< long2){
            return date1;
        }
        return date2;
    }

}
