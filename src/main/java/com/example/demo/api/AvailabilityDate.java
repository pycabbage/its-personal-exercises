package com.example.demo.api;

import com.example.demo.data.AvailabilityStatus;

import java.time.LocalDate;

public record AvailabilityDate(
    LocalDate date,
    AvailabilityStatus status
) {
}
