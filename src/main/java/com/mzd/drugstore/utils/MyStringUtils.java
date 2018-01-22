package com.mzd.drugstore.utils;

import java.util.UUID;

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

    public static String getuuid() {
        UUID u = UUID.randomUUID();
        String s = u.toString().replaceAll("-", "");
        return s;
    }
}
