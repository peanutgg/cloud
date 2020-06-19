package com.example.hystrix.Controller;

import com.example.hystrix.Pojo.Instance;
import com.example.hystrix.feignClients.HystrixFeignClents;
import com.example.hystrix.service.InstanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class HystrixController {
    @Autowired
    private Instance instance;
    @Autowired
    InstanceService instanceService;
    @Autowired
    HystrixFeignClents hystrixFeignClents;

    @RequestMapping("/testHystrix/{serviceId}")
    public Instance getInstance(@PathVariable String serviceId) {

        return instanceService.getInstanceByServiceIdWithRestTemplate(serviceId);

    }
    @RequestMapping("/instance/{serviceId}")
    public Instance getInstance2(@PathVariable String serviceId) {
        return instance;
    }

    @RequestMapping("/testOpenFeignHystrix/{str}")
    public String  testOpenFeignHystrix(@PathVariable String str){

        hystrixFeignClents.testOpenFeignHystrix("123333");
        return "success";
    }
}
