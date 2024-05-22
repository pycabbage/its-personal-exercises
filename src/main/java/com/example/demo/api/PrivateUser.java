package com.example.demo.api;

public record PrivateUser(
    Long userId,
    String name,
    String displayName,
    String password
) {
}
