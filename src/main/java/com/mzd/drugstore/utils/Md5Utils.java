package com.mzd.drugstore.utils;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {
    public static String getMD5(String str) {
        if (StringUtils.isNotEmpty(str)) {
            MessageDigest digest = null;
            try {
                digest = MessageDigest.getInstance("Md5");
            } catch (NoSuchAlgorithmException e) {
                System.err.println(Md5Utils.class.getName() + "初始化失败");
                e.printStackTrace();
            }
            if (digest != null) {
                byte[] bytes = str.getBytes();
                byte[] results = digest.digest(bytes);
                StringBuilder sb = new StringBuilder();
                for (byte result : results) {
                    // 将byte数组转化为16进制字符存入StringBuilder中
                    sb.append(String.format("%02x", result));
                }
                return sb.toString();
            }
        }
        return null;
    }

//    public static void main(String[] args) {
//        String s = getMD5("123");
//        System.out.println(s);
//    }
}
