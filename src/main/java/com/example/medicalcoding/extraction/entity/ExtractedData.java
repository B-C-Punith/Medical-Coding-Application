package com.example.medicalcoding.extraction.entity;


import com.example.medicalcoding.document.entity.Document;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "extracted_data")
@Data
public class ExtractedData {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne
        @JoinColumn(name = "document_id")
        private Document document;

        @Lob
        @Column(columnDefinition = "TEXT")
        private String extractedJson; // raw AI JSON response, stored as text for now

        @Lob
        @Column(columnDefinition = "TEXT")
        private String confidenceJson; // per-field confidence, also stored as text for now

        private LocalDateTime createdAt;

        @PrePersist
        protected void onCreate() {
            createdAt = LocalDateTime.now();
        }


}
