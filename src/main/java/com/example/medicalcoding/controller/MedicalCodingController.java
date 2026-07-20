package com.example.medicalcoding.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class MedicalCodingController {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/appdetails")
    public String getAppDetails() {
        return "App Name: " + appName + "\nApp Version: " + appVersion;
    }

    @GetMapping("/health")
    public String health() {
        return "Backend is running and connected!";
    }

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    // first api /api/auth/login

    @PostMapping("/auth/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        username = username.trim();
        password = password.trim();
        return username + "," + password;
    }
}