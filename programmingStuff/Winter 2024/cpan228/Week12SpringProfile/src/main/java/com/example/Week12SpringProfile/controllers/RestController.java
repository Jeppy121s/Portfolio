package com.example.Week12SpringProfile.controllers;


import com.example.Week12SpringProfile.services.DBConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    private final DBConfig dbConfig;

    public RestController(DBConfig dbConfig) {
        this.dbConfig = dbConfig;
    }
    @GetMapping
    public String getDBConfig(){
        return dbConfig.setUpDBConnection();
    }
}
