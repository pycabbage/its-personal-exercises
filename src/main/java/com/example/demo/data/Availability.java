package com.example.demo.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Availability {
    @Id
    @GeneratedValue
    private Long availabilityId;

    @ManyToOne()
    private Schedule schedule;

    @ManyToOne()
    private User createdBy;
}
