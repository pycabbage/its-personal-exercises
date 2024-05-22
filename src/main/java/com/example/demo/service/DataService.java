package com.example.demo.service;

import java.time.LocalDate;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.Availability;
import com.example.demo.data.AvailabilityDate;
import com.example.demo.data.AvailabilityDateRepository;
import com.example.demo.data.AvailabilityRepository;
import com.example.demo.data.AvailabilityStatus;
import com.example.demo.data.Period;
import com.example.demo.data.PeriodRepository;
import com.example.demo.data.Schedule;
import com.example.demo.data.ScheduleRepository;
import com.example.demo.data.User;
import com.example.demo.data.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class DataService {
    private static final Logger log = LoggerFactory.getLogger(DataService.class);
//    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    AvailabilityRepository availabilityRepository;
    @Autowired
    AvailabilityDateRepository availabilityDateRepository;
    @Autowired
    PeriodRepository periodRepository;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    UserRepository userRepository;

    /**
     * ユーザー登録
     */
    public User registerUser(
            String name,
            String displayName,
            String password) {
        Boolean isExists = userRepository.existsByName(name);
        if (isExists) {
            log.info("user already exists: " + name);
            return this.getUser(name);
        } else {
            log.info("user not exists: " + name);
            return userRepository.save(new User(
                name,
                displayName,
                // encoder.encode(password))
                password
            ));
        }
    }

    /**
     * ユーザー名/パスワードを検証
     */
    public Boolean isValidAuth(String name, String password) {
        return userRepository.existsUserByNameAndPassword(name, password);
    }

    public User getUser(String name) {
        return userRepository.findByName(name);
    }
    public User getUser(Long userId) {
        return userRepository.findUserByUserId(userId);
    }

    /**
     * 予定登録
     */
    public Schedule createSchedule(
            String title,
            String description,
            Long userId,
            LocalDate start,
            LocalDate end
    ) {
        // ユーザーの検証
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("ユーザーが存在しません: " + userId));

        // 予定表の作成
        Schedule schedule = Schedule.builder()
                .title(title)
                .description(description)
                .createdBy(user)
                .build();
        schedule = scheduleRepository.save(schedule);

        // 期間の設定
        Period period = Period.builder()
                .schedule(schedule)
                .start(start)
                .end(end)
                .build();
        periodRepository.save(period);
        return schedule;
    }

    /**
     * 予定を書き込む
     */
    public Schedule writeSchedule(
            Long scheduleId,
            Long userId,
            LocalDate date,
            AvailabilityStatus status
    ) {

        // ユーザーの検証
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("ユーザーが存在しません: " + userId));

        // 予定の検証
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("予定が存在しません: " + scheduleId));

        // 既存のAvailabilityの取得または新規作成
        Availability availability = availabilityRepository
                .findByScheduleAndCreatedBy(schedule, user)
                .orElseGet(() -> {
                    Availability newAvailability = Availability.builder()
                            .schedule(schedule)
                            .createdBy(user)
                            .build();
                    return availabilityRepository.save(newAvailability);
                });
        // AvailabilityDateの設定
        AvailabilityDate availabilityDate = AvailabilityDate.builder()
                .availability(availability)
                .date(date)
                .status(status)
                .build();
        availabilityDateRepository.save(availabilityDate);
        return schedule;
    }

    /**
     * 予定を取得
     */
    public Schedule getSchedule(Long scheduleId) {
        return scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("予定が存在しません: " + scheduleId));
    }
}
