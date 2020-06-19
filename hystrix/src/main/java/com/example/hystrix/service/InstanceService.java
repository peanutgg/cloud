package com.example.hystrix.service;

import com.example.hystrix.Pojo.Instance;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
@Slf4j
public class InstanceService {
    public static String DEFAULT_SERVICE_ID = "application";
    public static String DEFAULT_HOST = "localhost";
    public static String DEFAULT_PORT = "8080";
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "instanceInfoGetFail")
    public Instance getInstanceByServiceIdWithRestTemplate(String serviceId) {

        ResponseEntity<Instance> forEntity = restTemplate.getForEntity("http://FEIGN-CLIENT-SERVICE/instance/{serviceId}", Instance.class, serviceId);
        Instance body = forEntity.getBody();
        return body;
    }

    /**
     * 失败回滚方法
     *
     * @param serviceId
     * @return
     */
    private Instance instanceInfoGetFail(String serviceId) {
        log.info("Can not  get Instance By ServiceId {}", serviceId);
        return new Instance("error", "error", "0");
    }

    /**
     * Hystrix 除了同步执行命令 ，还可以异步以及异步回调执行命令
     *
     * 异步执行命令
     */
    @HystrixCommand(fallbackMethod = "getInstanceFailAsync")
    public Future<Instance> getInstanceByServiceIdAsync(String serviceId) {
        log.info("getInstanceFailAsync is executed... ");

        return new AsyncResult<Instance>() {
            @Override
            public Instance invoke() {
                return restTemplate.getForEntity("http://FEIGN-CLIENT-SERVICE/instance/{serviceId}", Instance.class, serviceId).getBody();
            }
        };
    }

    /**
     * 异步执行失败方法
     * @param serviceId
     * @return
     */
    @HystrixCommand
    public Future<Instance> getInstanceFailAsync(String serviceId) {
        log.info("getInstanceFailAsync is executed...");
        return new AsyncResult<Instance>() {
            @Override
            public Instance invoke() {
                return new Instance("error", "error", "0");
            }
        };
    }

    /**
     * 异步回调执行命令
     */


}
