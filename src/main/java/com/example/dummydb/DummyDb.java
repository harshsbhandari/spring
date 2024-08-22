package com.example.dummydb;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DummyDb {
    private  Map<String, String> db = new HashMap<>();

    public DummyDb(){
        this.db.put("Roger", "1234");
    }

    public Map<String, String> getDb() {
        return this.db;
    }
}
