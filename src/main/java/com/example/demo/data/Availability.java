package com.example.demo.data;

import jakarta.persistence.*;
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

    @ManyToOne()
    private Schedule schedule;

    @ManyToOne()
    private User createdBy;
}
