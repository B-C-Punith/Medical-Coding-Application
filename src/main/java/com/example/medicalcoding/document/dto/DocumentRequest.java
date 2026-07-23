package com.example.medicalcoding.document.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DocumentRequest {
    @NotBlank
    private String patientName;

    @NotBlank
    private String fileName;
}
