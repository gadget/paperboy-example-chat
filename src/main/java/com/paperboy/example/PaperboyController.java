package com.paperboy.example;

import com.paperboy.connector.PaperboyConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class PaperboyController {

    @Autowired
    private PaperboyConnector paperboyConnector;

    @Secured("ROLE_USER")
    @GetMapping(path = "/paperboyAuth/{channel}")
    public String requestToken(Principal principal, @PathVariable String channel) {
        return paperboyConnector.generateToken(principal, channel);
    }

    @Secured("ROLE_USER")
    @PostMapping(path = "/sendMessage/{channel}")
    public void sendMessage(Principal principal, @PathVariable String channel, @RequestBody String message) {
        // TODO: if authorization is needed for publishers, it needs to be implemented here as part of the application backend
        paperboyConnector.sendToChannel(channel, new ChatMessage(principal.getName(), message));
    }

    @PostMapping(path = "/messageCallback/{topic}")
    public void callBack(Principal principal, @PathVariable String topic, @RequestBody String message, @RequestHeader("PaperboyEmbeddedBackendToken") String embeddedBackendToken) {
        paperboyConnector.messageCallbackForEmbeddedBackend(topic, message, embeddedBackendToken);
    }
}
