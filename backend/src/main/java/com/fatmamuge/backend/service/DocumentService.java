package com.fatmamuge.backend.service;

import com.fatmamuge.backend.entity.Document;
import com.fatmamuge.backend.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    public Document getById(Integer id) {
        return documentRepository.findById(id).orElse(null);
    }

    public Document create(Document document) {
        return documentRepository.save(document);
    }

    public Document update(Integer id, Document document) {
        Document existing = documentRepository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setSale(document.getSale());
        existing.setUser(document.getUser());
        existing.setUploadedAt(document.getUploadedAt());
        existing.setFileName(document.getFileName());

        return documentRepository.save(existing);
    }

    public boolean delete(Integer id) {
        if (!documentRepository.existsById(id)) {
            return false;
        }

        documentRepository.deleteById(id);
        return true;
    }
}
