package com.EventManagementSystem.EventManagementSystem.service.serviceImpl;

import com.EventManagementSystem.EventManagementSystem.dto.AuthRequest;
import com.EventManagementSystem.EventManagementSystem.dto.UserDTO;
import com.EventManagementSystem.EventManagementSystem.exception.UserNotFoundException;
import com.EventManagementSystem.EventManagementSystem.mapper.UserMapper;
import com.EventManagementSystem.EventManagementSystem.model.User;
import com.EventManagementSystem.EventManagementSystem.model.VerifyUser;
import com.EventManagementSystem.EventManagementSystem.repository.UserRepository;
import com.EventManagementSystem.EventManagementSystem.repository.VerifyUserRepository;
import com.EventManagementSystem.EventManagementSystem.service.UserService;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authManager;
    private final UserRepository userRepository;
    private final VerifyUserRepository verifyUserRepository;
    public UserServiceImpl(UserRepository userRepository, VerifyUserRepository verifyUserRepository , AuthenticationManager authManager) {
        this.userRepository = userRepository;
        this.verifyUserRepository = verifyUserRepository;
        this.authManager = authManager;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }



    @Override
    public String createUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.convertDtoToEntity(userDTO);
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setRole("ROLE_USER");
//        User savedUser = userRepository.save(user);
        userRepository.save(user);
        return "User Created Successfully";
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

    @Override
    public void saveVerifyUser(byte[] citizenshipImage, byte[] userImage) {
        VerifyUser verifyUser = new VerifyUser();
        verifyUser.setCitizenshipImage(citizenshipImage);
        verifyUser.setUserImage(userImage);

        verifyUserRepository.save(verifyUser);
    }

}
