package com.mzd.drugstore.utils;

import java.util.UUID;

public class MyStringUtils {
    private static final String string[] = {"0", "1", "2", "3", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

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

    /**
     * 获取uuid
     *
     * @return
     */
    public static String getuuid() {
        UUID u = UUID.randomUUID();
        String s = u.toString().replaceAll("-", "");
        return s;
    }

    /**
     * 返回指定个数的字符串
     *
     * @param i
     * @return
     */
    public static String getcode(int i) {
        String str = "";
        for (int k = 0; k < i; k++) {
            str += string[(int) (Math.random() * (string.length))];
        }
        return str;
    }
}
