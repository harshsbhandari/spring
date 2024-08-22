package com.example.controller;

import com.example.service.DummyLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DummyLoginController {
    @Autowired
    DummyLoginService dummyLoginService;

    @RequestMapping("/test")
    @ResponseBody
    public ResponseEntity<String>  get(){
        return ResponseEntity.ok("Hello World");
    }

    /*
    * Pass key-value pair from Postman
    * */
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> loginPage(@RequestParam("user") String user){
        if(dummyLoginService.validateUser(user))
            return ResponseEntity.ok("Login Successful");

        return ResponseEntity.status(HttpStatusCode.valueOf(401)).body("Login Unsuccessful");
    }
}
