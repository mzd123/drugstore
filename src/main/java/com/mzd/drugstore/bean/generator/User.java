package com.mzd.drugstore.bean.generator;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.Map;

public class User implements HttpSessionBindingListener {
    private String userId;

    private String userName;

    private String userPassword;

    private String userTel;

    private String userEmail;

    private String userCreatetime;

    private String userStatus;

    private String userRoleid;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserCreatetime() {
        return userCreatetime;
    }

    public void setUserCreatetime(String userCreatetime) {
        this.userCreatetime = userCreatetime == null ? null : userCreatetime.trim();
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    public String getUserRoleid() {
        return userRoleid;
    }

    public void setUserRoleid(String userRoleid) {
        this.userRoleid = userRoleid == null ? null : userRoleid.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userCreatetime='" + userCreatetime + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userRoleid='" + userRoleid + '\'' +
                '}';
    }

    /**
     * request.getSession().setAttribute("user", user)的时候触发
     *
     * @param httpSessionBindingEvent
     */
    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();
        Map<String, HttpSession> map = (Map<String, HttpSession>) session.getServletContext().getAttribute("map");
        map.put(this.userId, session);
    }

    /**
     * session被销毁的时候触发
     *
     * @param httpSessionBindingEvent
     */
    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();
        Map<String, HttpSession> map = (Map<String, HttpSession>) session.getServletContext().getAttribute("map");
        map.remove(this.userId);
    }
}