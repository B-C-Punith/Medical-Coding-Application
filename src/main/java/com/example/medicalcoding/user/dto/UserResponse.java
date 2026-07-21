package com.example.medicalcoding.user.dto;

import com.example.medicalcoding.common.enums.UserRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {

    private Long id;
    private String username;
    private String email;
    private UserRole role;
    private String status;
    private LocalDateTime createdAt;
}
