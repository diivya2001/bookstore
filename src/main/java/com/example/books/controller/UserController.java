package com.example.books.controller;

import com.example.books.model.User;
import com.example.books.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return new ResponseEntity<>(userService.register(user), HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<User> authenticate(@RequestBody User user) {
        return new ResponseEntity<>(userService.authenticate(user), HttpStatus.OK);
    }
}
