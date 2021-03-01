package com.example.userservice.controller;

import com.example.userservice.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class UserController {
    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {

        log.info("name is ------------" + name);
        return "hello service" + name;
    }

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public User getUserByUserName(@PathVariable("userName") String userName) {
        logger.info("Get user by userName from port : {} of userservice instance", request.getServerPort());

        User user = new User();

        user.setId(001L);

        user.setUserCode("mockUser");

        user.setUserName(userName);

        return user;
    }
}
