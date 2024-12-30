package com.dev.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class DemoController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
