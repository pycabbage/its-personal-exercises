package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface AvailabilityRepository extends JpaRepository<Availability, Long>{
    ArrayList<Availability> findAllBySchedule(Schedule schedule);
}
