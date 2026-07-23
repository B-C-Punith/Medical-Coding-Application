package com.example.medicalcoding.document.dto;

import com.example.medicalcoding.common.enums.DocumentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DocumentResponse {

    private Long id;
    private String patientName;
    private String fileName;
    private DocumentStatus status;
    private String uploadedByUsername;
    private LocalDateTime uploadDate;
}
