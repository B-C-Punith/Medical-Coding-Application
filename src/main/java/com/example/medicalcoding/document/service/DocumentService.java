package com.example.medicalcoding.document.service;

import com.example.medicalcoding.common.exception.ResourceNotFoundException;
import com.example.medicalcoding.document.dto.DocumentRequest;
import com.example.medicalcoding.document.dto.DocumentResponse;
import com.example.medicalcoding.document.entity.Document;
import com.example.medicalcoding.document.mapper.DocumentMapper;
import com.example.medicalcoding.document.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    public List<DocumentResponse> getAllDocuments() {
        return documentRepository.findAll().stream()
                .map(documentMapper::toResponse)
                .toList();
    }

    public DocumentResponse getDocumentById(Long id) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Document not found: " + id));
        return documentMapper.toResponse(document);
    }

    public DocumentResponse createDocument(DocumentRequest request) {
        Document document = new Document();
        document.setPatientName(request.getPatientName());
        document.setFileName(request.getFileName());
        Document saved = documentRepository.save(document);
        return documentMapper.toResponse(saved);
    }

    public void deleteDocument(Long id) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Document not found: " + id));
        documentRepository.delete(document);
    }

}
