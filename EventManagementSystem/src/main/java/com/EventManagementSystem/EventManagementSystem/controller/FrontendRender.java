package com.EventManagementSystem.EventManagementSystem.controller;

import org.springframework.ui.Model;

import com.EventManagementSystem.EventManagementSystem.dto.EventDTO;
import com.EventManagementSystem.EventManagementSystem.dto.UserDTO;
import com.EventManagementSystem.EventManagementSystem.service.EventService;
import com.EventManagementSystem.EventManagementSystem.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class FrontendRender {
	
    private final UserService userService;
    public FrontendRender(UserService userService) {
        this.userService = userService;
    }
    
    @Autowired
    private EventService eventService;
    
    @GetMapping("/admin/admin-dashboard")
    public String adminDashboard() {
        return "admin/admin__dashboard";
    }

    @GetMapping("/admin/admin-all-users")
    public String adminAllUsers(Model model) {
        List<UserDTO> users = userService.getAllUsers(); // Fetch users from the service
        model.addAttribute("users", users);
        return "admin/admin__all__users";
    }
    
    @GetMapping("/admin/admin-all-events")
    public String adminAllEvents(Model model) {
    	List<EventDTO> events = eventService.getAllEvents();
    	model.addAttribute("events",events);
    	return "admin/admin_all_events";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }


    @GetMapping("/sign-in")
    public String signin() {
        return "signin";
    }

    @GetMapping("/sign-up")
    public String signup(Model model) {
        return "signup";
    }
    @PostMapping("/sign-up")
    public String registerUser(@ModelAttribute("user") UserDTO userDTO) {
        userService.createUser(userDTO); // Save user using service
        return "redirect:/register?success";
    }
    


    
    @GetMapping("/footer")
    public String getfot() {
        return "footer";
    }
    
    
}
