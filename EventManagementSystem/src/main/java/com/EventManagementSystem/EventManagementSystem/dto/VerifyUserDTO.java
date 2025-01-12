package com.EventManagementSystem.EventManagementSystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyUserDTO {

    private Long id; // Unique identifier for the VerifyUser
    private Long userId;// ID of the associated User
    private byte[] citizenshipImage; // Citizenship image in binary form
    private byte[] userImage; // User image in binary form
}