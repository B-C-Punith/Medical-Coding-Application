package com.example.medicalcoding.document.mapper;

import com.example.medicalcoding.document.dto.DocumentResponse;
import com.example.medicalcoding.document.entity.Document;
import org.springframework.stereotype.Component;


@Component
public class DocumentMapper {

    public DocumentResponse toResponse(Document document) {
        DocumentResponse dto = new DocumentResponse();
        dto.setId(document.getId());
        dto.setPatientName(document.getPatientName());
        dto.setFileName(document.getFileName());
        dto.setStatus(document.getStatus());
        dto.setUploadedByUsername(
                document.getUploadedBy() != null ? document.getUploadedBy().getUsername() : null
        );
        dto.setUploadDate(document.getUploadDate());
        return dto;
    }
}
