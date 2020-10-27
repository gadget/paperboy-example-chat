package com.paperboy.example;

import com.paperboy.connector.MessageSender;
import com.paperboy.connector.PaperboyCallbackHandler;

public class TestAppCallbackHandler implements PaperboyCallbackHandler {

    @Override
    public void onSubscription(MessageSender msgSender, String userId, String channel) {
        // msgSender.sendToUser(userId, null); // TODO: send init/snapshot
    }

    @Override
    public boolean hasAccess(String userId, String channel) {
        return true;
    }

}
