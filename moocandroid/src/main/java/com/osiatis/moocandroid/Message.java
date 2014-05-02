package com.osiatis.moocandroid;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Java bean that stores a message entry.
 */
public class Message {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("HH:mm");
    private final String userName;
    private final String message;
    private final String time;

    public Message(String userName, String message) {
        this.userName = userName;
        this.message = message;
        this.time = SDF.format(new Date());
    }

    public String getTime() {
        return time;
    }


    public String getUserName() {
        return userName;
    }


    public String getMessage() {
        return message;
    }

}
