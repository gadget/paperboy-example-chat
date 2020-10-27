package com.paperboy.example;

import com.paperboy.connector.MessageSender;
import com.paperboy.connector.PaperboyCallbackHandler;

public class ChatAppCallbackHandler implements PaperboyCallbackHandler {

    @Override
    public void onSubscription(MessageSender msgSender, String userId, String channel) {
        msgSender.sendToChannel(channel, new ChatMessage("system", String.format("User '%s' joined.", userId)));
    }

    @Override
    public boolean hasAccess(String userId, String channel) {
        return true;
    }

}
