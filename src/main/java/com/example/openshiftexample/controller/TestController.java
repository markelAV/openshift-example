package com.example.openshiftexample.controller;

import com.example.openshiftexample.dao.User;
import com.example.openshiftexample.dao.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/echo")
    public ResponseEntity<String> testEcho(@RequestParam String line) {
        return new ResponseEntity<>(line, HttpStatus.OK);
    }

    @GetMapping("/ping")
    public ResponseEntity<String> testEcho() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(usersRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(usersRepository.save(user), HttpStatus.OK);
    }
}

