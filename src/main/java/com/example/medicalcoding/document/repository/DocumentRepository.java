package com.example.medicalcoding.document.repository;

import com.example.medicalcoding.document.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  DocumentRepository extends JpaRepository<Document, Long> {

}
