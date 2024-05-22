package com.example.demo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @Entity @NoArgsConstructor
public class UserPeriod {
    @Id
    private Long id;

    @ManyToOne
    private UserSchedule userSchedule;

    @ManyToOne
    private User user;

    @NotNull
    private Date date;

    @NotNull
    @Enumerated
    private Availability availability = Availability.AVAILABLE;
}
