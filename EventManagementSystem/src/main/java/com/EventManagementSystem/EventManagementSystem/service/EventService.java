package com.EventManagementSystem.EventManagementSystem.service;

import java.util.List;

import com.EventManagementSystem.EventManagementSystem.model.Event;

import org.springframework.stereotype.Service;

import com.EventManagementSystem.EventManagementSystem.dto.EventDTO;
import com.EventManagementSystem.EventManagementSystem.dto.UserDTO;

import java.util.List;

@Service
public interface EventService {
	
    List<EventDTO> getAllEvents();
	List<Event> getEvents();

	void createEvent(EventDTO eventDTO);

	void deleteEvent(Long id);
	
	

}
