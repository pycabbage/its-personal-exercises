package com.example.demo.data;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodRepository extends JpaRepository<Period, Long> {
    Period findBySchedule(@NotNull Schedule schedule);
}
