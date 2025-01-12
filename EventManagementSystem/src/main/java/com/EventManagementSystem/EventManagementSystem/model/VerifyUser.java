package com.EventManagementSystem.EventManagementSystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Verifyusers")
public class VerifyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user; // Reference to the User entity

    @Lob
    @Column(nullable = false)
    private byte[] citizenshipImage; // For storing citizenship image

    @Lob
    @Column(nullable = false)
    private byte[] userImage; // For storing user image
}
