package com.EventManagementSystem.EventManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.EventManagementSystem.EventManagementSystem.dto.EventDTO;
import com.EventManagementSystem.EventManagementSystem.dto.UserDTO;

@Service
public interface EventService {
	
    List<EventDTO> getAllEvents();

	void createEvent(EventDTO eventDTO);

	void deleteEvent(Long id);
	
	

}
