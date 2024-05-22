package com.example.demo.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public User(
        String name,
        String displayName,
        String password
    ) {
        this.name = name;
        this.displayName = displayName;
        this.password = password;
    }

    @Id
    @GeneratedValue
    private Long userId;

    @NotBlank
    @UniqueElements
    private String name;

    @NotBlank
    private String displayName;

    @NotBlank
    private String password;
}
