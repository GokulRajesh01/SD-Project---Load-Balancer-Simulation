package com.LoadBalancer.service;

import com.LoadBalancer.config.BackendServer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RoundRobinStrategy {
    private AtomicInteger currentIndex = new AtomicInteger(0);

    public String getNextUrl(List<BackendServer> servers){
        int urlIndex = currentIndex.getAndUpdate((index) -> (index+1)% servers.size());
        BackendServer server = servers.get(urlIndex);
        return server.url();
    }
}
