package com.example.demo.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Availability {
    @Id
    @GeneratedValue
    private Long availabilityId;

    @ManyToOne
    @NotNull
    private Schedule schedule;

    @ManyToOne
    @NotNull
    private User createdBy;
}
