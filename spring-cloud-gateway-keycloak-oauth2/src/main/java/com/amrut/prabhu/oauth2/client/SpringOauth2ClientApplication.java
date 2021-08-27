package com.amrut.prabhu.oauth2.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = ReactiveUserDetailsServiceAutoConfiguration.class)
public class SpringOauth2ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringOauth2ClientApplication.class, args);
    }

}
