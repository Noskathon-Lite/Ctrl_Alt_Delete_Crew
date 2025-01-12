package com.EventManagementSystem.EventManagementSystem.repository;

import com.EventManagementSystem.EventManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
