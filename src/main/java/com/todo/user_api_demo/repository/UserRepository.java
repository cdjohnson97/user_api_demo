package com.todo.user_api_demo.repository;

import com.todo.user_api_demo.model.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean findByEmail(String email);
    // Custom query methods can be added here if needed
}