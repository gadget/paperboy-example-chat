package com.paperboy.example;

import com.paperboy.connector.PaperboyConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class PaperboyAuthController {

    @Autowired
    private PaperboyConnector paperboyConnector;

    @GetMapping(path = "/paperboyAuth/{channel}")
    public String requestToken(Principal principal, @PathVariable String channel) {
        return paperboyConnector.requestToken(principal, channel);
    }

    @PostMapping(path = "/sendMessage/{channel}")
    public void sendMessage(@PathVariable String channel, @RequestBody String message) {
        paperboyConnector.sendToChannel(channel, new SimpleMessage(message));
    }

}
