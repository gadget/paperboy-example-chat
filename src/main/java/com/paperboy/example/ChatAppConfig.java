package com.paperboy.example;

import com.paperboy.connector.PaperboyCallbackHandler;
import com.paperboy.connector.PaperboyConnector;
import com.paperboy.connector.RedisBackend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class ChatAppConfig {

    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private PaperboyCallbackHandler callbackHandler;

    @Bean
    public JedisPool jedisPool() {
        return new JedisPool(new JedisPoolConfig(), "localhost");
    }

    @Bean
    public PaperboyCallbackHandler paperboyCallbackHandler() {
        return new ChatAppCallbackHandler();
    }

    @Bean
    public PaperboyConnector paperboyConnector() {
        PaperboyConnector connector = new PaperboyConnector(new RedisBackend(jedisPool), callbackHandler);
        connector.init();
        return connector;
    }
}
