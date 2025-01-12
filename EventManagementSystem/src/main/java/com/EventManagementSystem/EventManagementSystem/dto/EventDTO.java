package com.EventManagementSystem.EventManagementSystem.dto;

import java.time.LocalDateTime;

import com.EventManagementSystem.EventManagementSystem.model.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
	public class EventDTO {
	
		private long id;
		
		private User user;
		
		private String eventName;
		
		private String description;
		
		private LocalDateTime date;
		
		private String location;
		
		private int participants;
		
		private LocalDateTime createdAt;
}
