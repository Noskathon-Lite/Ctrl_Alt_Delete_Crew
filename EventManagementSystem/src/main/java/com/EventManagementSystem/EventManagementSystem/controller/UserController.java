package com.EventManagementSystem.EventManagementSystem.controller;


import com.EventManagementSystem.EventManagementSystem.dto.UserDTO;
import com.EventManagementSystem.EventManagementSystem.service.EmailSenderService;
import com.EventManagementSystem.EventManagementSystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserService userService;
    private final EmailSenderService emailSenderService;
    public UserController(UserService userService, EmailSenderService emailSenderService) {
        this.userService = userService;
        this.emailSenderService = emailSenderService;
    }




    // API to create a new user
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // API to get all users
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // API to delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //For verify User
    @PostMapping("/VerifyUser")
    public ResponseEntity<String> uploadImages(
            @RequestParam("citizenshipImage") MultipartFile citizenshipImage,
            @RequestParam("userImage") MultipartFile userImage) {

        try {
            userService.saveVerifyUser(citizenshipImage.getBytes(), userImage.getBytes());
            return ResponseEntity.ok("Images uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload images.");
        }
    }

    //Send email Api
    @GetMapping("/sendEmail")
    public String sendEmail() {
        String subject = "Test subject";
        String body = "Test text";
        emailSenderService.sendEmail(subject, body);
        return "Email sent successfully to all users";
    }
    
   


}
