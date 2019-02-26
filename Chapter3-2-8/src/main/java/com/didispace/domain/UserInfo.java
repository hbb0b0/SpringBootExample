package com.didispace.domain;

/*
* UserInfo
* */
public class UserInfo {
    private String userName;
    private int userAge;
    private long userID;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int age) {
        this.userAge = age;
    }
}
