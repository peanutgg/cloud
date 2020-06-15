package com.example.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class QueryApplication {
    public static void main(String[] args) {

        SpringApplication.run(QueryApplication.class, args);
    }

    @RequestMapping("/test")
    public String test() {

        return "hello eureka client";
    }

}
