package com.fatmamuge.backend.controller;

import com.fatmamuge.backend.entity.Document;
import com.fatmamuge.backend.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    public List<Document> getAll() {
        return documentService.getAll();
    }

    @GetMapping("/{id}")
    public Document getById(@PathVariable Integer id) {
        return documentService.getById(id);
    }

    @PostMapping
    public Document create(@RequestBody Document document) {
        return documentService.create(document);
    }

    @PutMapping("/{id}")
    public Document update(
            @PathVariable Integer id,
            @RequestBody Document document) {
        return documentService.update(id, document);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        documentService.delete(id);
    }
}
