package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Value("${activeDef:def}")
    private String activeDef;

    @Value("${activeDev:dev}")
    private String activeDev;

    @GetMapping("/get")
    public String get() {
        return activeDef + " - " + activeDev;
    }
}