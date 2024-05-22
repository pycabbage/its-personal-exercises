package com.example.demo;

import com.example.demo.data.Schedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
    private static final Logger log = LoggerFactory.getLogger(MainRestController.class);

    @PostMapping("/createSchedule")
    public void createSchedule(
        @RequestBody Schedule schedule
    ) {
        log.info("Schedule created: {}", schedule.toString());
    }
}
