package com.EventManagementSystem.EventManagementSystem.controller;

import ch.qos.logback.core.model.Model;
import com.EventManagementSystem.EventManagementSystem.dto.UserDTO;
import com.EventManagementSystem.EventManagementSystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontendRender {
    private final UserService userService;
    public FrontendRender(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/admin/admin-dashboard")
    public String adminDashboard() {
        return "admin/admin__dashboard";
    }

    @GetMapping("/admin/admin-all-users")
    public String adminAllUsers() {
        return "admin/admin__all__users";
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

    
}
