package com.example.service;

import com.example.dummydb.DummyDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyLoginService {
    @Autowired
    DummyDb dummyDb;

    public boolean validateUser(String user){
        if(dummyDb.getDb().containsKey(user))
            return true;

        return false;
    }
}
