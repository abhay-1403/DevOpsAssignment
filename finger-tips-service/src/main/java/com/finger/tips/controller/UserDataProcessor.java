package com.finger.tips.controller;

import com.finger.tips.dto.LoginRequest;
import com.finger.tips.model.User;
import com.finger.tips.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odata")
public class UserDataProcessor {

    @Autowired
    private UserLoginService userLoginService;

    @GetMapping("/allUsers")
    public List<User> getAllUser(){
        return userLoginService.getAllUsers();
    }
    @PostMapping("/register")
    public void addUser(@RequestBody User user){
        userLoginService.postUser(user);
    }
    @GetMapping("/login")
    public ResponseEntity<HttpStatus> loginCheck(@RequestBody LoginRequest loginRequest){
        Optional<User> user = userLoginService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());
        if(user.isPresent()){
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
