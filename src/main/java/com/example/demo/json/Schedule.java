package com.example.demo.json;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long scheduleId;
    private LocalDate date;
    private String title;
    private List<Availability> availability;
}
