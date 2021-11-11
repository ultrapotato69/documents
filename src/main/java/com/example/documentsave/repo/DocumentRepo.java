package com.example.documentsave.repo;

import com.example.documentsave.dto.DocumentView;
import com.example.documentsave.domain.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepo extends JpaRepository<Document, Long> {

    @EntityGraph(attributePaths = {"codes"})
    Page<DocumentView> findAllProjectedBy(Pageable pageable);
    @EntityGraph(attributePaths = {"codes"})
    Page<DocumentView> findAllByCodesOrderById(Long code, Pageable pageable);
    @EntityGraph(attributePaths = {"codes"})
    Page<DocumentView> findAllDistinctByCodesGreaterThanOrderById(Long code, Pageable pageable);
    @EntityGraph(attributePaths = {"codes"})
    Page<DocumentView> findAllDistinctByCodesLessThanOrderById(Long code, Pageable pageable);
}
