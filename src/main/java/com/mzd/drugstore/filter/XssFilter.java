package com.mzd.drugstore.filter;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Xss过滤器
 */
public class XssFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(XssFilter.class);
    // 是否过滤富文本内容
    private static boolean IS_INCLUDE_RICH_TEXT = false;

    public List<String> excludes = new ArrayList<String>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("------------ xss filter init ------------");
        String isIncludeRichText = filterConfig.getInitParameter("isIncludeRichText");
        if (StringUtils.isNotBlank(isIncludeRichText)) {
            IS_INCLUDE_RICH_TEXT = BooleanUtils.toBoolean(isIncludeRichText);
        }
        //排除接口路径中含有这些参数的路径，不然接口提交的参数都需要进行过滤
        String temp = filterConfig.getInitParameter("excludes");
        if (temp != null) {
            String[] url = temp.split(",");
            for (int i = 0; url != null && i < url.length; i++) {
                excludes.add(url[i]);
            }
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (handleExcludeURL(req, resp)) {
            chain.doFilter(request, response);
            return;
        }
        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) request,
                IS_INCLUDE_RICH_TEXT);
        chain.doFilter(xssRequest, response);
    }

    @Override
    public void destroy() {

    }

    private boolean handleExcludeURL(HttpServletRequest request, HttpServletResponse response) {
        if (excludes == null || excludes.isEmpty()) {
            return false;
        }
        /**
         * http://localhost:8080/news/main/getlist.do
         * 则执行下面向行代码后打印出如下结果：
         *  1、 System.out.println(request.getContextPath());   打印结果：/news
         *  2、System.out.println(request.getServletPath());    打印结果：/main/getlist.do
         *  3、 System.out.println(request.getRequestURI());    打印结果：/news/main/getlist.do
         *  4、 System.out.println(request.getRealPath("/"));   打印结果：项目的根路径
         */
        String url = request.getServletPath();
        for (String pattern : excludes) {
            //正则匹配,如果含有excludes中的任意一个就返回true
            Pattern p = Pattern.compile("^" + pattern);
            System.out.println("^" + pattern);
            Matcher m = p.matcher(url);
            if (m.find())
                return true;
        }
        return false;
    }

}
