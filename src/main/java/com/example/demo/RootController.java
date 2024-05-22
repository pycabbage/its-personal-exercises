package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    private static final Logger log = LoggerFactory.getLogger(RootController.class);

    @GetMapping("/")
    public String index() {
        log.info("index");
        return "index";
    }

    @GetMapping("/content")
    public String content() {
        log.info("content");
        return "index";
    }
}
