package com.mzd.drugstore.bean.generator;

public class User {
    private String userId;

    private String userName;

    private String userPassword;

    private String userTel;

    private String userEmail;

    private String userCreatetime;

    private String userStatus;

    private String userMoney;

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

    public String getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(String userMoney) {
        this.userMoney = userMoney == null ? null : userMoney.trim();
    }

    public String getUserRoleid() {
        return userRoleid;
    }

    public void setUserRoleid(String userRoleid) {
        this.userRoleid = userRoleid == null ? null : userRoleid.trim();
    }
}