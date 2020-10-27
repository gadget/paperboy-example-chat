package com.paperboy.example;

import com.paperboy.connector.PaperboyConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class PaperboyAuthController {

    @Autowired
    private PaperboyConnector paperboyConnector;

    @GetMapping(path = "/paperboyAuth/{channel}")
    public String requestToken(Principal principal, @PathVariable String channel) {
        return paperboyConnector.requestToken(principal, channel);
    }

}
