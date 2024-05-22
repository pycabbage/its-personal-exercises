package com.example.demo.restapi;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AvailabilityStatus {
    private LocalDate date;
    private com.example.demo.data.AvailabilityStatus availability;
}
