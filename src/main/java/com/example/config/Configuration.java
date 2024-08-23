package com.example.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Configuration {
    private static Map<String, String> db = new HashMap<>();
    private static Boolean isInitialised = false;

    @Value("${app.user}")
    private String user;

    @Value("${app.userPassword}")
    private String userPassword;

    @Value("${app.admin}")
    private String admin;

    @Value("${app.adminPassword}")
    private String adminPassword;

    @Value("${app.guest}")
    private String guest;

    @Value("${app.guestPassword}")
    private String guestPassword;

    @PostConstruct
    public void init(){
        if(!isInitialised) {
            db.put(user, userPassword);
            db.put(admin, adminPassword);
            db.put(guest, guestPassword);
            isInitialised = true;
        }
    }

    public static Map<String, String> getDb() {
        return db;
    }
}
