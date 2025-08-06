package com.beratyesbek.springcloudgcpbqstoresfirestore.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.spring.data.firestore.FirestoreTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
