package com.example.feign.feignClents;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("hello-client-service")
public interface FeignServiceClient {
    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    String hello(@PathVariable("name") String name);
}
