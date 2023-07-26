package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        return restTemplate.getForObject("http://service-provider/echo/" + string, String.class);
    }

    @GetMapping("/config/get")
    public String configGet() {
        return restTemplate.getForObject("http://service-provider/config/get", String.class);
    }
}