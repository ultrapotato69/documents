package com.example.documentsave.repo;

import com.example.documentsave.dto.DocumentView;
import com.example.documentsave.domain.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepo extends JpaRepository<Document, Long> {
    Page<DocumentView> findAllProjectedBy(Pageable pageable);
    Page<DocumentView> findAllByCodesOrderById(Long code, Pageable pageable);
    Page<DocumentView> findAllDistinctByCodesGreaterThanOrderById(Long code, Pageable pageable);
    Page<DocumentView> findAllDistinctByCodesLessThanOrderById(Long code, Pageable pageable);
}
