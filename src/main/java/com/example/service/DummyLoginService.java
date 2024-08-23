package com.example.service;

import com.example.config.Configuration;
import com.example.dummydb.DummyDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DummyLoginService {
//    @Autowired
//    Configuration configuration;

    public ResponseEntity<String> validateUser(String user, String password){
        if(Configuration.getDb().containsKey(user)) {
            if(Configuration.getDb().get(user).equals(password))
                return ResponseEntity.ok("Login Successful");
        }

        return ResponseEntity.status(HttpStatusCode.valueOf(401)).body("Login Unsuccessful");
    }
}
