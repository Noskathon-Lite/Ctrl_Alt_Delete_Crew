package com.EventManagementSystem.EventManagementSystem.service;

import com.EventManagementSystem.EventManagementSystem.model.Event;
import org.springframework.stereotype.Service;

import com.EventManagementSystem.EventManagementSystem.dto.EventDTO;

import java.util.List;

@Service
public interface EventService {
	List<Event> getEvents();

	void createEvent(EventDTO eventDTO);

	void deleteEvent(Long id);


	String getEventCreatorEmail();
	

}
