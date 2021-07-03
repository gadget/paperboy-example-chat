package com.paperboy.example;

import com.paperboy.connector.EmbeddedBackend;
import com.paperboy.connector.PaperboyCallbackHandler;
import com.paperboy.connector.PaperboyConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatAppConfig {

    @Autowired
    private PaperboyCallbackHandler callbackHandler;
    @Autowired
    private EmbeddedBackend embeddedBackend;

    @Bean
    public PaperboyCallbackHandler paperboyCallbackHandler() {
        return new ChatAppCallbackHandler();
    }

    @Bean
    public EmbeddedBackend embeddedBackend() {
        return new EmbeddedBackend("secretToken");
    }

    @Bean
    public PaperboyConnector paperboyConnector() {
        PaperboyConnector connector = new PaperboyConnector(embeddedBackend, callbackHandler);
        connector.init();
        return connector;
    }
}
