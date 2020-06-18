package com.example.hystrix.service;

import com.example.hystrix.Pojo.Instance;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    private Instance instanceInfoGetFail(String serviceId) {
        log.info("Can not  get Instance By ServiceId {}", serviceId);
        return new Instance("error", "error", "0");
    }
}
