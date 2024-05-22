package com.example.demo.restapi;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.html.Option;
import java.util.Optional;

@Getter
@AllArgsConstructor
public class Schedule {
    private String title;
    private String description = "";
    private Long createdBy;
    private Period period;

//    public Schedule(com.example.demo.data.Schedule createdSchedule, Period period) {
//        this.title = createdSchedule.getTitle();
//        this.description = createdSchedule.getDescription();
//        this.createdBy = createdSchedule.getCreatedBy().getUserId();
//        this.period = period;
//    }

//    public Schedule(
//        com.example.demo.data.Schedule createdSchedule,
//        Period period
//    ) {
//        this.title = createdSchedule.getTitle();
//        this.description = createdSchedule.getDescription();
//        this.createdBy = createdSchedule.getCreatedBy().getUserId();
//        this.period = period;
//    }
}
