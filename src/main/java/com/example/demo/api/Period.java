package com.example.demo.api;

import java.time.LocalDate;

public record Period(
    LocalDate start,
    LocalDate end
) {
}
