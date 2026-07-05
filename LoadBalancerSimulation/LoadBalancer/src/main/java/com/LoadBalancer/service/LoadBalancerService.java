package com.LoadBalancer.service;

import com.LoadBalancer.config.BackendProperties;
import com.LoadBalancer.config.BackendServer;
import org.springframework.stereotype.Service;

import java.net.ServerSocket;
import java.util.List;

@Service
public class LoadBalancerService {
    private List<String> servers;

    private BackendProperties properties;

    private RoundRobinStrategy strategy;

    public LoadBalancerService(BackendProperties properties, RoundRobinStrategy strategy){
        this.properties = properties;
        this.strategy = strategy;
    }

    public String sayHello(){
        return strategy.getNextUrl(properties.servers());
    }
}
