package com.mzd.drugstore.utils;

public class MyStringUtils {
    /**
     * 防止toString()出现空指针
     *
     * @param o
     * @return
     */
    public static String Object2String(Object o) {
        String s = "";
        if (o != null) {
            s = o.toString();
        }
        return s;
    }
}
