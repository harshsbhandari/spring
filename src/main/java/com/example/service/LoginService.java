package com.example.service;

import com.example.config.ConfigurationFile;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginService {
    @Autowired
    ConfigurationFile configurationFile;

//    @Autowired
//    AES256TextEncryptor aes256TextEncryptor;

    public ResponseEntity<String> validateUser(String user, String password){

//        if(configurationFile.getUserMap().containsKey(user)) {
//            String encryptedPassword = configurationFile.getUserMap().get(user);
//            String decryptedPassword = aes256TextEncryptor.decrypt(encryptedPassword);
//
//            if(password.equals(decryptedPassword))
//                return ResponseEntity.ok("Login Successful");
//        }

        return ResponseEntity.status(HttpStatusCode.valueOf(401)).body("Login Unsuccessful");
    }
}
