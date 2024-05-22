package com.example.demo;

import com.example.demo.json.Availability;
import com.example.demo.json.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
