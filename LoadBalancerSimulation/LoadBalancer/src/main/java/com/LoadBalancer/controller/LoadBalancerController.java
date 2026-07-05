package com.LoadBalancer.controller;

import com.LoadBalancer.service.LoadBalancerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadBalancerController {
    private final LoadBalancerService loadBalancerService;

    public LoadBalancerController(LoadBalancerService loadBalancerService){
        this.loadBalancerService = loadBalancerService;
    }

    @GetMapping("api/v1/sayHello")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loadBalancerService.sayHello());
    }
}
