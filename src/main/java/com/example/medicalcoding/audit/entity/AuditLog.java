package com.example.medicalcoding.audit.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
@Data
public class AuditLog {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;

        private String action;

        @Lob
        @Column(columnDefinition = "TEXT")
        private String oldValue;

        @Lob
        @Column(columnDefinition = "TEXT")
        private String newValue;

        private LocalDateTime date;

        @PrePersist
        protected void onCreate() {
            date = LocalDateTime.now();
        }

}
