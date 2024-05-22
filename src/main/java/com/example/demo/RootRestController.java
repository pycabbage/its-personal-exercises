package com.example.demo;

import com.example.demo.data.AvailabilityStatus;
import com.example.demo.json.Availability;
import com.example.demo.json.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
public class RootRestController {
    @Autowired
    DataService dataService;

    @GetMapping("/schedule")
    public Schedule getSchedule(
        @RequestParam(name = "id", required = true) Long id
    ) {
        var schedule = dataService.getSchedule(id);
        var dbAvailabilities = dataService.getAvailabilities(id);

        ArrayList<Availability> availabilities = dbAvailabilities.stream().map(avail -> new Availability(
            avail.getAvailabilityId(),
            avail.getUsername(),
            avail.getStatus()
        )).collect(Collectors.toCollection(ArrayList::new));

        return new Schedule(
            schedule.getScheduleId(),
            schedule.getDate(),
            schedule.getTitle(),
            availabilities
        );
    }

    @PostMapping("/schedule")
    public void registerSchedule(
        @RequestParam(required = true) String title,
        @RequestParam(required = true) LocalDate date,
        @RequestParam(required = true) String username,
        @RequestParam(required = true) AvailabilityStatus status
    ) {
        dataService.register(
            title,
            date,
            username,
            status
        );
    }

    @PutMapping("/schedule")
    public void updateSchedule(
        @RequestParam(required = true) Long scheduleId,
        @RequestParam(required = true) String username,
        @RequestParam(required = true) AvailabilityStatus status
    ) {
        dataService.insertAvailability(scheduleId, username, status);
    }
}
