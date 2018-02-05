package com.mzd.drugstore.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class IpUtils {
    /**
     * 笔记：参考于http://blog.csdn.net/chwshuang/article/details/71940858
     * <p>
     * 获取客户端的IP地址的方法是：request.getRemoteAddr（），这种方法在大部分情况下都是有效的。
     * <p>
     * 如果使用了Apache，Squid,nginx等反向代理软件，用 request.getRemoteAddr（）方法获取的IP地址是：127.0.0.1或 192.168.1.110，而并不是客户端的真实IP。
     * <p>
     * 如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值， 取 X-Forwarded-For中第一个非unknown的有效IP字符串。
     * 如： X-Forwarded-For：192.168.1.110， 192.168.1.120， 192.168.1.130， 192.168.1.100 用户真实IP为： 192.168.1.110
     * 具体就像这样：X-Forwarded-For: client, proxy1, proxy2，proxy3…
     * <p>
     * <p>
     * 如果 X-Forwarded-For 获取不到，就去获取X-Real-IP ，X-Real-IP 获取不到，就依次获取Proxy-Client-IP 、WL-Proxy-Client-IP 、HTTP_CLIENT_IP 、 HTTP_X_FORWARDED_FOR 。
     * 最后获取不到才通过request.getRemoteAddr()获取IP。
     * X-Real-IP 就是记录请求的客户端真实IP。跟X-Forwarded-For 类似。
     * Proxy-Client-IP 顾名思义就是代理客户端的IP，如果客户端真实IP获取不到的时候，就只能获取代理客户端的IP了。
     * WL-Proxy-Client-IP 是在Weblogic下获取真实IP所用的的参数。
     * HTTP_CLIENT_IP 与 HTTP_X_FORWARDED_FOR 可以理解为X-Forwarded-For ， 因为它们是PHP中的用法。
     */
    public static String getIp(HttpServletRequest request) {
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if (index != -1) {
                return XFor.substring(0, index);
            } else {
                return XFor;
            }
        }
        XFor = Xip;
        if (StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
            return XFor;
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return XFor;
    }
}
