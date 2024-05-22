package com.example.demo.restapi;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@AllArgsConstructor
public class Schedule {

//    private static final Logger log = LoggerFactory.getLogger(Schedule.class);

//    public Schedule(
//        com.example.demo.data.Schedule aSchedule,
//        com.example.demo.data.Period period
//    ) {
//        super();
//        log.info("constructor with period");
//        this.title = aSchedule.getTitle();
//        this.description = aSchedule.getDescription();
//        this.createdBy = aSchedule.getCreatedBy().getUserId();
//        this.period = new Period(period);
//    }

    private String title;
    private String description = "";
    private Long createdBy;
    private Period period;
}
