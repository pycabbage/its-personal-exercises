package com.example.demo;

import com.example.demo.data.AvailabilityRepository;
import com.example.demo.data.AvailabilityStatus;
import com.example.demo.data.Availability;
import com.example.demo.data.Schedule;
import com.example.demo.data.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class DataService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private AvailabilityRepository availabilityRepository;

    public Schedule register(
        String title,
        LocalDate date,
        String username,
        AvailabilityStatus status
    ) {
        var schedule = scheduleRepository.save(new Schedule(
            title, date
        ));
        availabilityRepository.save(new Availability(
            username, status, schedule
        ));
        return schedule;
    }

    public Schedule getSchedule(Long scheduleId) {
        return scheduleRepository.findById(scheduleId)
            .orElseThrow();
    }

    public ArrayList<Availability> getAvailabilities(Long scheduleId) {
        return availabilityRepository.findAllBySchedule(scheduleRepository.findByScheduleId(scheduleId));
    }


    public Schedule insertAvailability(
        Long scheduleId,
        String username,
        AvailabilityStatus status
    ) {
        Schedule schedule = getSchedule(scheduleId);
        Availability availability = new Availability(
            username,
            status,
            schedule
        );
        availabilityRepository.save(availability);
        return schedule;

        /*
         * Schedule schedule = this.getSchedule(scheduleId);
         * schedule.getAvailability().addLast(
         * availabilityRepository.save(new Availability(
         * username,
         * status,
         * schedule
         * ))
         * );
         * return scheduleRepository.save(schedule);
         * 
         */
    }
}
