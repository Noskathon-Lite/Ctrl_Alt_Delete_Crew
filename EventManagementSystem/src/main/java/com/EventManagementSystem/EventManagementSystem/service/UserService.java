package com.EventManagementSystem.EventManagementSystem.service;

import com.EventManagementSystem.EventManagementSystem.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    void deleteUser(Long id);
}
