package com.ddy.wxServer.Utils.checkString;

public class StringUtils {
    public static boolean isEmptyString(String str){
        if ("".equals(str)||str==null){
            return true;
        }else {
            return false;
        }
    }
    public static boolean isnotEmptyString(String str){
        if ("".equals(str)||str==null){
            return false;
        }else {
            return true;
        }
    }
}
