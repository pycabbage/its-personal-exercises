package com.example.demo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    public Schedule(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }


    @Id
    @GeneratedValue
    private Long scheduleId;

    @NotNull
    private LocalDate date;

    @NotBlank
    private String title;

    @OneToMany
    private List<Availability> availability;
}
