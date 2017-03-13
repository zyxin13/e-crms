package com.abc.crms.web.util;

/**
 * Created by yuxin.zou on 2017/3/13.
 */
public class IntegerUtil {
    public static boolean isInteger(String var) {
        try {
            Integer.valueOf(var);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}
