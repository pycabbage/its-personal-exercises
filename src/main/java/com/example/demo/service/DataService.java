package com.example.demo.service;

import com.example.demo.data.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@Service
@Transactional
public class DataService {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private ScheduleRepository scheduleRepository;
//    @Autowired
//    private UserScheduleRepository userScheduleRepository;
//
//    private final PasswordEncoder encoder = new BCryptPasswordEncoder();
//
//    /**
//     * ユーザー登録
//     */
//    public void registerUser(
//        String name,
//        String displayName,
//        String password
//    ) {
//        userRepository.save(new User(
//            name,
//            displayName,
//            encoder.encode(password)
//        ));
//    }
//
//    /**
//     * ユーザー名/パスワードを検証
//     */
//    public Boolean isValidAuth(String name, String password) {
//        return userRepository.existsUserByNameAndPassword(name, password);
//    }
//
//    /**
//     * 予定登録
//     */
//    public Schedule registerSchedule(Schedule schedule) {
//        return scheduleRepository.save(schedule);
//    }
//
//    /**
//     * 予定を書き込む
//     */
//    public UserSchedule writeSchedule(
//        ArrayList<UserPeriod> userPeriods
//    ) {
//        UserPeriod up = userPeriods.getFirst();
//
//        var us = new UserSchedule(
//            up.getUser(),
//            up.getUserSchedule().getSchedule()
//        );
//        return userScheduleRepository.save(us);
//    }
}
