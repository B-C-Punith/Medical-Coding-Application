package com.example.medicalcoding.user.dto;

import com.example.medicalcoding.common.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {

        @NotBlank
        private String username;

        @NotBlank
        private String password;

        @Email
        @NotBlank
        private String email;

        private UserRole role;

}
