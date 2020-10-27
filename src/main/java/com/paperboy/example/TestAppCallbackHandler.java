package com.paperboy.example;

import com.paperboy.connector.MessageSender;
import com.paperboy.connector.PaperboyCallbackHandler;
import com.paperboy.connector.Payload;

public class TestAppCallbackHandler implements PaperboyCallbackHandler {

    @Override
    public void onSubscription(MessageSender msgSender, String userId, String channel) {
        msgSender.sendToUser(userId, new SimpleMessage(String.format("Welcome user '%s' to channel '%s'!", userId, channel)));
    }

    @Override
    public boolean hasAccess(String userId, String channel) {
        return true;
    }

}
