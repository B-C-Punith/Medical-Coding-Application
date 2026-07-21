package com.example.medicalcoding.ocr.entity;


import com.example.medicalcoding.document.entity.Document;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ocr_text")
@Data
public class OcrText {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "document_id")
    private Document document;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String text;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
