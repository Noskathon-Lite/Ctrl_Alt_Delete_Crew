package com.EventManagementSystem.EventManagementSystem.controller;

import com.EventManagementSystem.EventManagementSystem.dto.EventDTO;
import com.EventManagementSystem.EventManagementSystem.service.EmailService;
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

    @Autowired
    private EmailService emailService;

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

    @PostMapping("/express-interest")
    public ResponseEntity<String> expressInterest() {
        // Use eventId = 1 directly
//        String eventCreatorEmail = eventService.getEventCreatorEmail(); // No need to pass eventId anymore
        String eventCreatorEmail = "abinash.201603@ncit.edu.np"; // No need to pass eventId anymore

        if (eventCreatorEmail != null) {
            // Compose and send the email as before
            String subject = "User Interested in Your Event";
            String text = "Hello,\n\nUser with ID:   has expressed interest in your event!";
            emailService.sendEmail(eventCreatorEmail, subject, text);
            return ResponseEntity.ok("Interest sent successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found.");
        }
    }


}
