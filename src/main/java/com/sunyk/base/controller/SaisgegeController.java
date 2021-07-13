package com.sunyk.base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SaisgegeController {
    @RequestMapping("/sai")
    public String HelloWorld(){
        return "Hello World!";
    }

}
