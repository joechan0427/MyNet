package com.joe.entity;

import java.util.Date;

public class Memo {
    private String memoId;

    private Date editTime;

    private Date sendTime;

    private String userId;

    private Integer state;

    @Override
    public String toString() {
        return "Memo{" +
                "memoId='" + memoId + '\'' +
                ", editTime=" + editTime +
                ", sendTime=" + sendTime +
                ", userId='" + userId + '\'' +
                ", state=" + state +
                ", memoContent='" + memoContent + '\'' +
                '}';
    }

    private String memoContent;

    public String getMemoId() {
        return memoId;
    }

    public void setMemoId(String memoId) {
        this.memoId = memoId == null ? null : memoId.trim();
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMemoContent() {
        return memoContent;
    }

    public void setMemoContent(String memoContent) {
        this.memoContent = memoContent == null ? null : memoContent.trim();
    }
}