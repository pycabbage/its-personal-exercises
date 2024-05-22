package com.example.demo.restapi;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleOut {
    public ScheduleOut(
        Long scheduleId,
        Schedule schedule
    ) {
        this.scheduleId = scheduleId;
        this.title = schedule.getTitle();
        this.description = schedule.getDescription();
        this.createdBy = schedule.getCreatedBy();
        this.period = schedule.getPeriod();
    }


    private Long scheduleId;

    private String title;
    private String description = "";
    private Long createdBy;
    private Period period;
}
