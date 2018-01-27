package com.college.food.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yichen ─=≡Σ(((つ•̀ω•́)つ) on 2017/8/14.
 */
public class DateUtil {

    protected static String formatString = "yyyy-MM-dd HH:mm:ss";

    protected static String formatString2 = "yyyy-MM-dd";

    public static String DateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(formatString);
        return sdf.format(date);
    }

    public static String DataToString_yyyyMMdd(Date date){
        SimpleDateFormat sdf2 = new SimpleDateFormat(formatString2);
        return sdf2.format(date);
    }

    public static String formatDuring(long ms) {
        long days = ms / (1000 * 60 * 60 * 24);
        long hours = (ms % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (ms % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (ms % (1000 * 60)) / 1000;
        return days + " 天 " + hours + " 时 " + minutes + " 分 "
                + seconds + " 秒 ";
    }

}
