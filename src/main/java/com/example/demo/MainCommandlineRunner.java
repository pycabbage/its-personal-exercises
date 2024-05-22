package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.demo.service.DataService;

@Component
public class MainCommandlineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(MainCommandlineRunner.class);

//    @Autowired
//    private DataService dataService;

    @Override
    public void run(String... args) {
        log.info("MainCommandlineRunner");
//        dataService.registerUser(
//            "test",
//            "test",
//            "test"
//        );
    }
}
