package main.java.com.lkq.javaUtils;

import java.util.Date;

public class MainTest {
    //测试例子
    public static void main(String[] args){
        testDateUtils();
        //testStringUtils();
    }

    public static void testDateUtils(){
        System.out.println(DateUtils.dateToString(new Date(), DateUtils.yyyy_MM_dd));
        System.out.println(DateUtils.dateIsWeek( "2018-09-17"));
        System.out.println(DateUtils.startToEndDate( 1, 7));
        System.out.println(DateUtils.startToEndDateByWeek( 1, 7,"1,2,3,0"));
        System.out.println(DateUtils.dateStrToLong("2018-09-19 19:10:00",DateUtils.yyyy_MM_dd_hh_mm_ss));
        System.out.println(DateUtils.longToDateStr(1537286400000L,DateUtils.yyyy_MM_dd_hh_mm_ss));
        System.out.println(DateUtils.compareDateTakeSmall("2018-09-19","2018-09-15"));
    }

    public static void testStringUtils(){
        System.out.println(StringUtils.isEmpty("aa"));
        System.out.println(StringUtils.isNotEmpty("aa"));
    }
}
