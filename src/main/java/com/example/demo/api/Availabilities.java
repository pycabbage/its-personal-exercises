package com.example.demo.api;

import java.util.List;
import java.util.Objects;

public record Availabilities(
    PublicUser createdBy,
    List<AvailabilityDate> dates
) {
    public Availabilities {
        Objects.requireNonNull(createdBy, "createdBy must not be null");
        Objects.requireNonNull(dates, "dates must not be null");
    }
}
