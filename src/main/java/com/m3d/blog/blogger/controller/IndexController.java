package com.m3d.blog.blogger.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    private static final String msg = "Welcome to blog service @ %s";

    @GetMapping
    public String hello() {
        return String.format(msg, sdf.format(new Date()));
    }
}