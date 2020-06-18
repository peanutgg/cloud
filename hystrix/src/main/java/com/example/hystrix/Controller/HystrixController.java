package com.example.hystrix.Controller;

import com.example.hystrix.Pojo.Instance;
import com.example.hystrix.service.InstanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HystrixController {

    @Autowired
    InstanceService instanceService;

    @RequestMapping("/testHystrix/{serviceId}")
    public Instance getInstance(@PathVariable String serviceId){

        return instanceService.getInstanceByServiceIdWithRestTemplate(serviceId);

    }



}
