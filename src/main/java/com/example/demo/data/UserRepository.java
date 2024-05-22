package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsUserByNameAndPassword(String name, String password);
    User findByName(String name);
    User findUserByUserId(Long id);
}
