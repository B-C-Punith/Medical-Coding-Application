package com.example.medicalcoding.document.entity;


import com.example.medicalcoding.common.enums.DocumentStatus;

import com.example.medicalcoding.user.entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "documents")
@Data
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;

    private String fileName;

    @Enumerated(EnumType.STRING)
    private DocumentStatus status;

    @ManyToOne
    @JoinColumn(name = "uploaded_by")
    private User uploadedBy;

    private LocalDateTime uploadDate;

    @PrePersist
    protected void onCreate() {
        uploadDate = LocalDateTime.now();
        status = DocumentStatus.UPLOADED;
    }

}
