package com.BackEndServer2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/api/v1/hello")
    public ResponseEntity<String> helloResponse(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Hello, from server 2!");
    }
}