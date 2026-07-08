package com.BackEndServer2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HelloController {
    private final AtomicInteger reqCount = new AtomicInteger(0);

    @GetMapping("/api/v1/hello")
    public ResponseEntity<String> helloResponse(){
        reqCount.incrementAndGet();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Hello, from server 2!");
    }

    @GetMapping("/count")
    public String getReqCount(){
        return "Server 2 Count : " + reqCount.get();
    }
}