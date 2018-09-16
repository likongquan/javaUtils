package main.java.com.lkq.javaUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

    /**
     *  判断字符串为空
     *  调用例子：
     *  System.out.println(StringUtils.isEmpty("aa"));
     *  return：false
     */
    public static boolean isEmpty(String str){
        return str == null || "".equals(str);
    }

    /**
     *  判断字符串不为空
     *  调用例子：
     *  System.out.println(StringUtils.isNotEmpty("aa"));
     *  return：true
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
