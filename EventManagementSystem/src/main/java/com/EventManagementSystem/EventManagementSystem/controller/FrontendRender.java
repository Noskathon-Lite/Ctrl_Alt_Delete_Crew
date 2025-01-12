package com.EventManagementSystem.EventManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FrontendRender {
    @GetMapping("/signup")
    public String login() {
        return "signup";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
