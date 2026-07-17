package com.example.medicalcoding.medicalcoding.user.entity;


import com.example.medicalcoding.medicalcoding.common.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;


import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String status;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
