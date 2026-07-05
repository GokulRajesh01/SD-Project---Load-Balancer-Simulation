package com.LoadBalancer.service;

import com.LoadBalancer.config.BackendServer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundRobinStrategy {
    private int currentIndex = 0;

    public String getNextUrl(List<BackendServer> servers){

        return servers.get(currentIndex).url();
    }
}
