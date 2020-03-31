package com.joe.entity;


//import org.hibernate.validator.constraints.Email;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
//import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashMap;

public class User {
    private String userId;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$")
    private String userNickname;

    @NotNull(message = "password cant be null")
    @Size(min = 6, max = 12, message = "password length is wrong")
    @Pattern(regexp = "^[A-Za-z0-9]{6,12}$")
    private String userPassword;

    @NotNull(message = "email cant be null")
    @Pattern(regexp = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$")
    @Email(message = "email error")
    private String userEmail;

    private Integer actiState;

    private String actiCode;

    private String salt;

    private Date tokenExptime;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", actiState=" + actiState +
                ", actiCode='" + actiCode + '\'' +
                ", salt='" + salt + '\'' +
                ", tokenExptime=" + tokenExptime +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Integer getActiState() {
        return actiState;
    }

    public void setActiState(Integer actiState) {
        this.actiState = actiState;
    }

    public String getActiCode() {
        return actiCode;
    }

    public void setActiCode(String actiCode) {
        this.actiCode = actiCode == null ? null : actiCode.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Date getTokenExptime() {
        return tokenExptime;
    }

    public void setTokenExptime(Date tokenExptime) {
        this.tokenExptime = tokenExptime;
    }
}
