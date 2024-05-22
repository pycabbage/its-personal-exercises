package com.example.demo.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Availability {
    public Availability(String username, AvailabilityStatus status, Schedule schedule) {
        this.username = username;
        this.status = status;
        this.schedule = schedule;
    }

    @Id
    @GeneratedValue
    private Long availabilityId;

    @NotBlank
    private String username;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus status;

    @ManyToOne
    private Schedule schedule;
}
