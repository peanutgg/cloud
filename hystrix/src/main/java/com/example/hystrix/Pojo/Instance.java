package com.example.hystrix.Pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Instance {
    @Value("${spring.application.name}")
    private String serviceId;
    @Value("${eureka.instance.hostname}")
    private String host;
    @Value("${server.port}")
    private String port;

    public Instance(String serviceId,String host,String port ) {

        this.serviceId = serviceId;
        this.host = host;
        this.port = port;
    }

    public Instance() {
    }
}
