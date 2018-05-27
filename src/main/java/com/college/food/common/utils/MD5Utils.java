package com.college.food.common.utils;

import java.security.MessageDigest;

/**
 * Created by yichen on 2017/4/28.
 */
public class MD5Utils {

    private static final String[] hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();

        for(int i = 0; i < b.length; ++i) {
            resultSb.append(byteToHexString(b[i]));
        }

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if(b < 0) {
            n = b + 256;
        }

        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String encode(String origin) {
        return encode(origin, "utf-8");
    }

    public static String encode(String origin, String charsetname) {

        try {
            String resultString = origin;
            MessageDigest exception = MessageDigest.getInstance("MD5");
            if(charsetname != null && !"".equals(charsetname)) {
                resultString = byteArrayToHexString(exception.digest(resultString.getBytes(charsetname)));
            } else {
                resultString = byteArrayToHexString(exception.digest(resultString.getBytes()));
            }

            return resultString;
        } catch (Exception var4) {
            return null;
        }
    }

}
