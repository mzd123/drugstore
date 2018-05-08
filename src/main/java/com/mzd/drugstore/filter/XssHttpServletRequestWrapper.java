package com.mzd.drugstore.filter;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 重写getHeader和getParameter方法
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    HttpServletRequest orgRequest = null;

    private boolean isIncludeRichText = false;

    public XssHttpServletRequestWrapper(HttpServletRequest request, boolean isIncludeRichText) {
        super(request);
        orgRequest = request;
        this.isIncludeRichText = isIncludeRichText;
    }


    /**
     * 覆盖getHeader方法，将参数名和参数值都做xss过滤
     */
    @Override
    public String getHeader(String name) {
        name = JsoupUtil.clean(name);
        String value = super.getHeader(name);
        //判断某字符串是否不为空且长度不为0且不由空白符(whitespace)构成
        if (StringUtils.isNotBlank(value)) {
            value = JsoupUtil.clean(value);
        }
        return value;
    }


    /**
     * 2 每个方法参数
     * 覆盖getParameter方法，将参数名和参数值都做xss过滤
     * name表示在controller层中传入的参数
     */
    @Override
    public String getParameter(String name) {
        //如果参数名为content或者以WithHtml结尾，并且设置为不对富文本框内容进行过滤
        if (("content".equals(name) || name.endsWith("WithHtml")) && !isIncludeRichText) {
            //则通过super.getParameterValues(name)来获取原始的值，
            return super.getParameter(name);
        }
        //参数名字过滤
        name = JsoupUtil.clean(name);
        String value = super.getParameter(name);
        if (StringUtils.isNotBlank(value)) {
            //参数值过滤
            value = JsoupUtil.clean(value);
        }
        return value;
    }


    @Override
    public String[] getParameterValues(String name) {
        String[] arr = super.getParameterValues(name);
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = JsoupUtil.clean(arr[i]);
            }
        }
        return arr;
    }


    /**
     * 获取原始的request
     */
    public HttpServletRequest getOrgRequest() {
        return orgRequest;
    }

    /**
     * 获取原始的request的静态方法
     */
    public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
        if (req instanceof XssHttpServletRequestWrapper) {
            return ((XssHttpServletRequestWrapper) req).getOrgRequest();
        }
        return req;
    }

}
