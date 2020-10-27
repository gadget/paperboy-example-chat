package com.paperboy.example;

import com.paperboy.connector.Payload;

public class SimpleMessage implements Payload {

    private final String message;

    public SimpleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
