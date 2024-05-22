package com.example.demo.restapi;

import com.example.demo.data.PeriodRepository;
import com.example.demo.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class MainRestController {
    private static final Logger log = LoggerFactory.getLogger(MainRestController.class);
    private final DataService dataService;
    private final PeriodRepository periodRepository;

    public MainRestController(DataService dataService, PeriodRepository periodRepository) {
        this.dataService = dataService;
        this.periodRepository = periodRepository;
    }


    @GetMapping("/schedule")
    public ScheduleOut getSchedule(
        @RequestParam("scheduleId") Long scheduleId
    ) {
        com.example.demo.data.Schedule schedule = dataService.getSchedule(scheduleId);
        return new ScheduleOut(
            scheduleId,
            schedule.getTitle(),
            schedule.getDescription(),
            schedule.getCreatedBy().getUserId(),
            new Period(periodRepository.findBySchedule(schedule))
        );
    }

    @PostMapping("/schedule")
    public ScheduleOut createSchedule(
        @RequestBody Schedule schedule
    ) {
        com.example.demo.data.Schedule createdSchedule = dataService.createSchedule(
            schedule.getTitle(),
            schedule.getDescription(),
            schedule.getCreatedBy(),
            schedule.getPeriod().getStart(),
            schedule.getPeriod().getEnd()
        );

        var sc = new Schedule(
            createdSchedule.getTitle(),
            createdSchedule.getDescription(),
            createdSchedule.getCreatedBy().getUserId(),
            schedule.getPeriod()
        );

        return new ScheduleOut(
            createdSchedule.getScheduleId(),
            sc
        );
    }
}
