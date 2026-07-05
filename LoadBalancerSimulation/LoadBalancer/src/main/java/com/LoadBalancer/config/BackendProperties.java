package com.LoadBalancer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "backend")
public record BackendProperties(List<BackendServer> servers) {
}
