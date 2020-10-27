package com.paperboy.example;

import com.paperboy.connector.Payload;

public class SimpleMessage implements Payload {

    private final String userId;
    private final String message;

    public SimpleMessage(String userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

}
