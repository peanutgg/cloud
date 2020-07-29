package com.example.feign.Pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class Instance {
    @Value("${spring.application.name}")
    private String serviceId;
    @Value("${eureka.instance.hostname}")
    private String host;
    @Value("${server.port}")
    private String port;

    public Instance() {

    }

    public Instance(String serviceId, String host, String port) {

        this.serviceId = serviceId;
        this.host = host;
        this.port = port;
    }
}
