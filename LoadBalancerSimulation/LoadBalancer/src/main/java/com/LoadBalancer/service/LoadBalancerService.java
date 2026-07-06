package com.LoadBalancer.service;

import com.LoadBalancer.config.BackendProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadBalancerService {

    private final BackendProperties properties;

    private final RoundRobinStrategy strategy;

    private final HttpForwardingService httpForwardingService;

    public LoadBalancerService(BackendProperties properties, RoundRobinStrategy strategy, HttpForwardingService service){
        this.properties = properties;
        this.strategy = strategy;
        this.httpForwardingService = service;
    }

    public String sayHello(){
        String serverUrl =  strategy.getNextUrl(properties.servers());
        return httpForwardingService.forwardRequest(serverUrl);
    }
}
