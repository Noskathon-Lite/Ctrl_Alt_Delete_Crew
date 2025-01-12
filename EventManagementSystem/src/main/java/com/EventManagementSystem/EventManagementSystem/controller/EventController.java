package com.EventManagementSystem.EventManagementSystem.controller;

import com.EventManagementSystem.EventManagementSystem.dto.EventDTO;
import com.EventManagementSystem.EventManagementSystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    public ResponseEntity<String> createEvent(@RequestBody EventDTO eventDTO) {
        eventService.createEvent(eventDTO);
        return ResponseEntity.ok("Event created successfully!");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteEvent(@PathVariable Long id){
    	
    	eventService.deleteEvent(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    	
    	
    
}