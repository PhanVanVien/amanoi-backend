package com.devnotdev.amanoininhthuan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestClass {
    @GetMapping("/helllo")
    public String hello() {
        return "Hello World";
    }
}
