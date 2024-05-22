package com.example.demo.json;

import com.example.demo.data.AvailabilityStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Availability {
    private Long availabilityId;
    private String username;
    private AvailabilityStatus status;
}
