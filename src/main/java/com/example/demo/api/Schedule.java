package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.data.User;
import com.example.demo.service.DataService;

public record Schedule(
    Long scheduleId,
    String title,
    String description,
    User createdBy
) {

    @Autowired
    private static final DataService dataService = new DataService();

    public Schedule(com.example.demo.data.Schedule schedule) {
        this(
            schedule.getScheduleId(),
            schedule.getTitle(),
            schedule.getDescription(),
            schedule.getCreatedBy()
        );
    }

    public static Schedule getById(Long scheduleId) {
        return new Schedule(dataService.getSchedule(scheduleId));
    }
}
