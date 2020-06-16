package com.example.feign.controller;

import com.example.feign.feignClents.FeignServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FeignController {
    @Autowired
    FeignServiceClient feignServiceClient;
    @RequestMapping("/testFeign/{name}")
    public String testFeign(@PathVariable String name) {
        log.info("test Feing ------namme is ==" + name);
        feignServiceClient.hello(name);
        return "test Feing ------is ok";
    }

}
