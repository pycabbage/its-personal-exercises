package com.example.demo;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.demo.data.AvailabilityStatus;

@Component
public class MainCommandlineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(MainCommandlineRunner.class);

    @Autowired
    DataService dataService;


    @Override
    public void run(String... args) {
        log.info("commandline run ...");

        var schedule = dataService.register(
            "test",
            LocalDate.parse("2024-06-01"),
            "test",
            AvailabilityStatus.YES
        );
        dataService.insertAvailability(
            schedule.getScheduleId(),
            "test2",
            AvailabilityStatus.NO
        );
        dataService.insertAvailability(
            schedule.getScheduleId(),
            "test3",
            AvailabilityStatus.MAYBE
        );
    }
}
