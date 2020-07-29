package com.example.hystrix.feignClients;

import com.example.hystrix.FallbackClass.FallBackClass;
import com.example.hystrix.Pojo.Instance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "feign-client-service", fallback = FallBackClass.class)
public interface HystrixFeignClents {

    @RequestMapping("/testOpenFeignHystrix/{str}")
    public String testOpenFeignHystrix(@PathVariable String str);
}
