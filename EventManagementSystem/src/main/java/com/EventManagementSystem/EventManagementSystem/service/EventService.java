package com.EventManagementSystem.EventManagementSystem.service;

<<<<<<< HEAD
import java.util.List;

=======
import com.EventManagementSystem.EventManagementSystem.model.Event;
>>>>>>> 2416550e1f84688f87563bacb1549cf0309d6eef
import org.springframework.stereotype.Service;

import com.EventManagementSystem.EventManagementSystem.dto.EventDTO;
import com.EventManagementSystem.EventManagementSystem.dto.UserDTO;

import java.util.List;

@Service
public interface EventService {
<<<<<<< HEAD
	
    List<EventDTO> getAllEvents();
=======
	List<Event> getEvents();
>>>>>>> 2416550e1f84688f87563bacb1549cf0309d6eef

	void createEvent(EventDTO eventDTO);

	void deleteEvent(Long id);
	
	

}
