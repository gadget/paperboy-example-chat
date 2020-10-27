package com.paperboy.example;

import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void afterPropertiesSet() {
        setRealmName("DeveloperStack");
        super.afterPropertiesSet();
    }
}
