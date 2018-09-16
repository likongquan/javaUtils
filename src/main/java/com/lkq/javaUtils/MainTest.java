package main.java.com.lkq.javaUtils;

import java.util.Date;

public class MainTest {
    //测试例子
    public static void main(String[] args){
        testDateUtils();
        testStringUtils();
    }

    public static void testDateUtils(){
        System.out.println(DateUtils.dateToString(new Date(), DateUtils.yyyy_MM_dd));
        System.out.println(DateUtils.dateIsWeek( "2018-09-17"));
        System.out.println(DateUtils.startToEndDate( 1, 7));
        System.out.println(DateUtils.startToEndDateByWeek( 1, 7,"1,2,3,0"));
    }

    public static void testStringUtils(){
        System.out.println(StringUtils.isEmpty("aa"));
        System.out.println(StringUtils.isNotEmpty("aa"));
    }
}
