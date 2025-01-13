package com.EventManagementSystem.EventManagementSystem.service;

import org.springframework.stereotype.Service;

import com.EventManagementSystem.EventManagementSystem.dto.EventDTO;

@Service
public interface EventService {

	void createEvent(EventDTO eventDTO);

	void deleteEvent(Long id);


	String getEventCreatorEmail();
	

}
