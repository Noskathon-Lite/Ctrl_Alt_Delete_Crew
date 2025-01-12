package com.EventManagementSystem.EventManagementSystem.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id") // Foreign key to User
    private User user;

    private String eventName;

    private String description;

    private LocalDateTime date; // Changed to LocalDateTime for better date handling

    private String location;

    private int participants;

    private LocalDateTime createdAt;
}
