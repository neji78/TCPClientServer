package com.example.tcpclient;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class messageLab {
    private static messageLab sMessageLab;
    private ArrayList<messageItem> mMessages;
    messageLab() {
        mMessages = new ArrayList<>();
    }
    public void addMessage(messageItem item)
    {
        mMessages.add(item);
    }
    public List<messageItem> getMessages() {
        return mMessages;
    }
    public messageItem getMessage(UUID id) {
        for (messageItem message : mMessages) {
            if (message.getGuid().equals(id)) {
                return message;
            }
        }
        return null;
    }
}
