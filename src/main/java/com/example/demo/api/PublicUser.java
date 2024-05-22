package com.example.demo.api;

public record PublicUser(
    Long userId,
    String name,
    String displayName
) {
}
