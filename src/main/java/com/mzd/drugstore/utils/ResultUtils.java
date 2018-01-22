package com.mzd.drugstore.utils;

import com.mzd.drugstore.bean.MyResult;

public class ResultUtils {
    private static MyResult myResult = null;

    //私有化构造方法，产生单例模式
    private ResultUtils() {
    }

    ;

    public static MyResult getResult(String code, String message, Object object, int pageNum) {
        if (null == myResult) {
            synchronized (ResultUtils.class) {
                if (null == myResult) {
                    myResult = new MyResult(code, message, object, pageNum);
                }
            }
        } else {
            myResult.setCode(code);
            myResult.setMessage(message);
            myResult.setResult(object);
            myResult.setPageNum(pageNum);
        }
        return myResult;
    }
}
