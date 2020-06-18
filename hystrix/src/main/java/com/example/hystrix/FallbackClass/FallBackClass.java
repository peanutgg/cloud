package com.example.hystrix.FallbackClass;

import com.example.hystrix.Pojo.Instance;
import com.example.hystrix.feignClients.HystrixFeignClents;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FallBackClass implements HystrixFeignClents {

    @Override
    public String testOpenFeignHystrix(String str) {
        log.info("hystrix 以openfeign形式执行失败的回调方法被执行---");
        return "failed";
    }
}
