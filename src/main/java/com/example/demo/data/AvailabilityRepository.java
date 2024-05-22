package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    public Optional<Availability> findByScheduleAndCreatedBy(Schedule schedule, User createdBy);
}
