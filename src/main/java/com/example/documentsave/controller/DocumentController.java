package com.example.documentsave.controller;

import com.example.documentsave.domain.Document;
import com.example.documentsave.dto.DocumentDtoInitial;
import com.example.documentsave.dto.DocumentView;
import com.example.documentsave.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("documents")
public class DocumentController {
    private final DocumentService documentService;


    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public Document addDocument(@RequestBody DocumentDtoInitial documentDto) {
        return documentService.save(documentDto);
    }

    @GetMapping
    Page<DocumentView> getPages(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> filter,
            @RequestParam Optional<Long> code
    ) {
        return documentService.getPages(page, filter, code);
    }

    @GetMapping("{id}")
    public Optional<Document> findOne(@PathVariable Long id) {
        return documentService.findOne(id);
    }
}
