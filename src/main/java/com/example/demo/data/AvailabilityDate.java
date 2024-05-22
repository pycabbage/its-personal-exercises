package com.example.demo.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "availability_dates")
public class AvailabilityDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dateId;

    @ManyToOne()
    @NotNull
    private Availability availability;

    @NotNull
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @NotNull
    private AvailabilityStatus status;

    public enum AvailabilityStatus {
        NO,
        YES,
        MAYBE
    }
}
