package com.example.demo.controller;

import com.example.demo.entity.ConfigBean;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class,User.class})
public class HelloController {
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private String age;
    @Autowired
    ConfigBean configBean;
    @Autowired
    User user;

    @RequestMapping("/hello")
    public String index(){
        return "hello hello!!!!";
    }

    @RequestMapping("/hello1")
    public String index1(){
        return name+":"+age;
    }

    @RequestMapping("/hello2")
    public String my(){
        return configBean.toString();
    }

    @RequestMapping("/hello3")
    public String user(){
        return user.toString();
    }

}
