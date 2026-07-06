package com.LoadBalancer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class HttpForwardingService {
    private final RestClient client;

    public HttpForwardingService(RestClient client){
        this.client = client;
    }

    public String forwardRequest(String backendUrl){
        return client
                .get()
                .uri(backendUrl+"/api/v1/hello")
                .retrieve()
                .body(String.class);
    }
}
