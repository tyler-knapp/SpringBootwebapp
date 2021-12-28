package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @RequestMapping("/")
    public String home(){
        return "Hello from Spring Boot";
    }

    @RequestMapping("/home")
    public String homePage(){
        return "Hello";
    }

}
