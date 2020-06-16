package com.example.eurekaserver;

import com.example.demo.Filter.InportAutoConfiguration.annotations.EnableLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
@EnableLogFilter
@RestController
@EnableDiscoveryClient
public class EurekaServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(EurekaServerApplication.class, args);
    }

    @RequestMapping("/test")
    public String test() {

        return "hello eureka sever";
    }

}
