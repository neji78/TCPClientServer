package com.example.tcpclient;

import java.util.Date;
import java.util.UUID;

public class messageItem {
    public UUID getGuid() {
        return mGuid;
    }

    private UUID mGuid;

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    private String mUserName;
    private String mMessage;
    private Date mDate;

    public messageItem() {
        mGuid = UUID.randomUUID();
    }
}
