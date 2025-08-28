package com.example.Week12SpringProfile.services;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdDBConfig implements DBConfig{
    @Override
    public String setUpDBConnection() {

        return "setting up connection for Prod";
    }
}
