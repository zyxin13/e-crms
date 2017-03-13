package com.abc.crms.common;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by yuxin.zou on 2017/3/13.
 */
public class MD5Util {
    public static String encode(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            return null;
        }
    }
}
