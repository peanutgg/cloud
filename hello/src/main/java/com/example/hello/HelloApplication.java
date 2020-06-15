package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
//@RibbonClient(name="hello-client-service")
public class HelloApplication {

    public static void main(String[] args) {

        SpringApplication.run(HelloApplication.class, args);
    }

}
