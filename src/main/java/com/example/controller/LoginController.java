package com.example.controller;

import com.example.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService dummyLoginService;

    @Operation(summary = "Test api", description = "Simple get operation")
    @GetMapping("/test")
    public ResponseEntity<String>  get(){
        return ResponseEntity.ok("Hello World");
    }

    /*
    * Pass key-value pair from Postman
    * */
    @Operation(summary = "Pass user-name and password for validation", description = "Currently not working")
    @PostMapping("/login")
    public ResponseEntity<String> loginPage(@RequestParam("user") String user,
                                            @RequestParam("password") String password){
        var response =  dummyLoginService.validateUser(user, password);
        return response;
    }

}
