package com.mzd.drugstore.Listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    /**
     * 监听servletContext创建
     *
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Map<String, HttpSession> Map = new HashMap<String, HttpSession>();
        servletContextEvent.getServletContext().setAttribute("map", Map);
        System.out.println("servletContext被创建，用户列表已准备就绪");
    }

    /**
     * 监听servletContext销毁
     *
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
