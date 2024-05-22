package com.example.demo;

import com.example.demo.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RootController {
    private static final Logger log = LoggerFactory.getLogger(RootController.class);
    @Autowired
    DataService dataService;

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
