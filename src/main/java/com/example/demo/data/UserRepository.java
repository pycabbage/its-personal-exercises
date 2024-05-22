package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // ?
    User findUserByName(String username);
    Boolean existsUserByNameAndPassword(String name, String password);
}
