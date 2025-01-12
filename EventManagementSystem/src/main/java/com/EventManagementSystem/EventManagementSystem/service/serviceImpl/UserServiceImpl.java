package com.EventManagementSystem.EventManagementSystem.service.serviceImpl;

import com.EventManagementSystem.EventManagementSystem.dto.UserDTO;
import com.EventManagementSystem.EventManagementSystem.exception.UserNotFoundException;
import com.EventManagementSystem.EventManagementSystem.mapper.UserMapper;
import com.EventManagementSystem.EventManagementSystem.model.User;
import com.EventManagementSystem.EventManagementSystem.repository.UserRepository;
import com.EventManagementSystem.EventManagementSystem.service.UserService;



import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.convertDtoToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.INSTANCE.convertEntityToDto(savedUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream().map(UserMapper.INSTANCE::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        userRepository.deleteById(id);

    }
}
