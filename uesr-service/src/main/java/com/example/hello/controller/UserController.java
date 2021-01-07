package com.example.hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {
    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {

        log.info("name is ------------" + name);
        return "hello service" + name;
    }


}
