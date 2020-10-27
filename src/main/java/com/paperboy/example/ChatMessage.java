package com.paperboy.example;

import com.paperboy.connector.Payload;

public class ChatMessage implements Payload {

    private final String source;
    private final String message;

    public ChatMessage(String source, String message) {
        this.source = source;
        this.message = message;
    }

    public String getSource() {
        return source;
    }

    public String getMessage() {
        return message;
    }

}
