package com.example.medicalcoding.medicalcoding.user.entity;



import com.example.medicalcoding.medicalcoding.common.enums.UserRole;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class User {
 // create entity file

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(unique = true, nullable = false)
    private String username ;

    @Column(unique = true, nullable = false)
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
