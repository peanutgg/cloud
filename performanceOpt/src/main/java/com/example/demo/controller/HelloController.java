package com.example.demo.controller;

import com.example.demo.constant.ABean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private ABean aBean;

    @GetMapping("/hello")
    public String helloworld() {
        System.out.println("in...");
        return "success";
    }
    @GetMapping("/aop")
    public String aop() {
        long begin = System.currentTimeMillis();
        aBean.mehtod();
        long cost = System.currentTimeMillis() - begin;
        String cls = aBean.getClass().toString();
        return cls + " | " + cost;
    }
}
