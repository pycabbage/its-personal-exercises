package com.example.demo.restapi;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class UserSchedule {
    Long scheduleId;
    Long userId;
    ArrayList<AvailabilityStatus> status;
}
