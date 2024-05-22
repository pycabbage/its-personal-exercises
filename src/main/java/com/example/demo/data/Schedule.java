package com.example.demo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Schedule {
    @Id
    @GeneratedValue
    private Long scheduleId;

    @NotBlank()
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    @ManyToOne
    private User createdBy;
}
