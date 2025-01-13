package com.EventManagementSystem.EventManagementSystem.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EventManagementSystem.EventManagementSystem.dto.EventDTO;
import com.EventManagementSystem.EventManagementSystem.dto.UserDTO;
import com.EventManagementSystem.EventManagementSystem.exception.UserNotFoundException;
import com.EventManagementSystem.EventManagementSystem.mapper.EventMapper;
import com.EventManagementSystem.EventManagementSystem.mapper.UserMapper;
import com.EventManagementSystem.EventManagementSystem.model.Event;
import com.EventManagementSystem.EventManagementSystem.model.User;
import com.EventManagementSystem.EventManagementSystem.repository.EventRepository;
import com.EventManagementSystem.EventManagementSystem.repository.UserRepository;
import com.EventManagementSystem.EventManagementSystem.service.EventService;

@Service
public class EventServiceimpl implements EventService{

	
		@Autowired 
		private UserRepository userRepository;
		@Autowired
		private EventRepository eventRepository;
		
	    public void createEvent(EventDTO eventDTO) {
	        // Fetch the user by ID
	        Optional<User> userOptional = userRepository.findById(eventDTO.getUser().getId());

	        if (userOptional.isPresent()) {
	            User user = userOptional.get();

	            // Create a new Event object
	            Event event = new Event();
	            event.setUser(user); // Associate the user
	            event.setEventName(eventDTO.getEventName());
	            event.setDescription(eventDTO.getDescription());
	            event.setDate(eventDTO.getDate());
	            event.setLocation(eventDTO.getLocation());
	            event.setParticipants(eventDTO.getParticipants());
	            event.setCreatedAt(LocalDateTime.now());

	            // Save the event
	            eventRepository.save(event);
	        } else {
	            throw new RuntimeException("User with ID " + eventDTO.getUser().getId() + " not found!");
	        }
	    }

		@Override
		public void deleteEvent(Long id) {
			
			Event event = eventRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found"));
			eventRepository.deleteById(id);
			
		}

		@Override
		public List<EventDTO> getAllEvents() {
			List<Event> events = eventRepository.findAll();
	        return events.stream().map(EventMapper.INSTANCE::convertEntityToDto).collect(Collectors.toList());
		}
		

	    
	     
	    

}
