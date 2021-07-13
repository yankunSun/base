package com.sunyk.base.config;

import com.sunyk.base.security.SecurityTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public SecurityTest getSecurityTest(){
        return new SecurityTest();
    }
}
