package com.example.feign.controller;

import com.example.feign.Pojo.Instance;
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
    @Autowired
    private Instance instance;

    /**
     * 测试feignclient  调用hello service
     *
     * @param name
     * @return
     */
    @RequestMapping("/testFeign/{name}")
    public String testFeign(@PathVariable String name) {

        log.info("test Feing ------namme is ==" + name);
        feignServiceClient.hello(name);
        return "test Feing ------is ok";
    }


    @RequestMapping("/testOpenFeignHystrix/{str}")
    public String testOpenFeignHystrix(@PathVariable String str) {

        log.info("testOpenFeignHystrix  is success");
        return "success" + str;
    }

    @RequestMapping("/getInstance/{serviceId}")
    public Instance getInstance(@PathVariable String serviceId) {

        log.info("getInstance  in ");
        return new Instance();
    }


}
