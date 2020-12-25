package com.company;

public class User {

    private Long userId;
    private String userName;
    private String emailId;

    public User(Long userId, String userName, String emailId) {
        this.userId = userId;
        this.userName = userName;
        this.emailId = emailId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
