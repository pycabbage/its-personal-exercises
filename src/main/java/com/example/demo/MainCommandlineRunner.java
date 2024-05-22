package com.example.demo;

import com.example.demo.data.AvailabilityStatus;
import com.example.demo.data.Schedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.demo.service.DataService;

import java.time.LocalDate;

@Component
public class MainCommandlineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(MainCommandlineRunner.class);

    @Autowired
    private DataService dataService;

    @Override
    public void run(String... args) {
        log.info("MainCommandlineRunner");
        var user1 = dataService.registerUser(
            "test",
            "test",
            "test"
        );
        var user2 = dataService.registerUser(
            "test2",
            "test2",
            "test2"
        );
        Schedule schedule = dataService.createSchedule(
            "sample schedule",
            user1.getUserId(),
            LocalDate.parse("2024-06-01"),
            LocalDate.parse("2024-06-07")
        );

        for (int i = 1; i <= 7; i++) {
            dataService.writeSchedule(
                schedule.getScheduleId(),
                user1.getUserId(),
                LocalDate.parse("2024-06-" + String.format("%02d", i)),
                AvailabilityStatus.YES
            );
        }
        for (int i = 1; i <= 7; i++) {
            dataService.writeSchedule(
                schedule.getScheduleId(),
                user2.getUserId(),
                LocalDate.parse("2024-06-" + String.format("%02d", i)),
                AvailabilityStatus.MAYBE
            );
        }
        

    }
}
