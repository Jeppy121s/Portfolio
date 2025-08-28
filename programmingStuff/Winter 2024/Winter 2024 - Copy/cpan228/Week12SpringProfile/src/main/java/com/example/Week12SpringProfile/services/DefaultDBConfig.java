package com.example.Week12SpringProfile.services;


import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
@Primary
public class DefaultDBConfig implements DBConfig{
    @Override
    public String setUpDBConnection() {
        return "setting up connection for Default DB";
    }
}
