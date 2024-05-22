package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
    Schedule findByScheduleId(long id);
}
