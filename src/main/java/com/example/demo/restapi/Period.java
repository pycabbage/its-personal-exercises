package com.example.demo.restapi;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Period {
    public Period(com.example.demo.data.Period period) {
        this.start = period.getStart();
        this.end = period.getEnd();
    }

    private LocalDate start;
    private LocalDate end;
}
