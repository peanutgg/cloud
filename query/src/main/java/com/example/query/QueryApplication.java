package com.example.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableDiscoveryClient
public class QueryApplication {
    public static void main(String[] args) {

        SpringApplication.run(QueryApplication.class, args);
    }

    @Value("${spring.application.name}")
    private String name;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/askHello")
    public String test() {

        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://HELLO-CLIENT-SERVICE/hello/{name}", String.class, name);
        String askHelloService = forEntity.getBody();
        return askHelloService;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {

        return new RestTemplate();

    }

}
