package com.sframe.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    private static final Logger log = LoggerFactory.getLogger(StringUtil.class);

    public StringUtil() {
    }


    /**
     * 是否空串
     * 
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        if (s == null || "".equals(s.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 是否是正确的email地址
     */
    public static boolean isEmail(String parameter) {
        if (parameter == null) {
            return false;
        }
        Pattern reEmail = null;
        Matcher matcher = null;
        try {
            reEmail = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$");
            matcher = reEmail.matcher(parameter);
            return matcher.find();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return true;
        }
    }
    
    /**
     * 过滤 \r \n \t \s 等符号
     * @param str
     * @return
     */
    public static String filterBlankChars(String str){
        return filterChars(str, "\\s*|\t|\r|\n");
    }
    
    /**
     * 过滤字符串中的特殊字符
     * @param str 需要过滤的字符串
     * @param regex 过滤表达式，例：\\s*|\t|\r|\n 去掉 空格、回车、换行符、制表符
     * @return
     */
    public static String filterChars(String str, String regex){
        if(str == null){
            return null;
        }
        String content = new String(str);
        Pattern p = Pattern.compile(regex);
        return p.matcher(content).replaceAll("");
    }

    /**
     * 对象转化为字符串
     * null直接返回null
     * @Title: objToString
     * @param obj
     * @return
     */
    public static String objToString(Object obj) {
        if(null == obj){
            return null;
        }
        return String.valueOf(obj);
    }
}
