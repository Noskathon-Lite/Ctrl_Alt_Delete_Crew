package com.EventManagementSystem.EventManagementSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontendRender {
    @GetMapping("/signup")
    public String login() {
        return "signup";
    }
}
