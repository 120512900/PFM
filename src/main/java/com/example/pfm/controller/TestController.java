package com.example.pfm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {
    /**
     * /hh/id=1
     * /hh/1
     * @return
     */
    //@GetMapping("/hello")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "fffff";
    }

    @RequestMapping(value = "hello/post",method = RequestMethod.POST)
    public String helloPost(String name){
        return "post"+name;
    }
}
