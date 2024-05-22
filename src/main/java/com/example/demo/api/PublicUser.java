package com.example.demo.api;

import com.example.demo.data.User;
import com.example.demo.service.DataService;

public record PublicUser(
    Long userId,
    String name,
    String displayName
) {
    public PublicUser(User user) {
        this(user.getUserId(), user.getName(), user.getDisplayName());
    }

    private static DataService dataService;
    public static PublicUser getById(Long id) {
        User user = dataService.getUser(id);
        return new PublicUser(user);
    }
}
