package com.example.documentsave.service;

import com.example.documentsave.domain.Document;
import com.example.documentsave.dto.DocumentDtoInitial;
import com.example.documentsave.dto.DocumentView;
import com.example.documentsave.repo.DocumentRepo;
import com.example.documentsave.util.DocumentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DocumentService {
    private final DocumentRepo documentRepo;
    @Value("${document.page.size}")
    private int pageSize;

    @Autowired
    public DocumentService(DocumentRepo documentRepo) {
        this.documentRepo = documentRepo;
    }

    public Document save(DocumentDtoInitial dtoInitial) {
        Document document = new Document();
        document.setName(dtoInitial.getName());
        document.setText(dtoInitial.getText());
        document.setCodes(DocumentUtil.parseCodes(document.getText()));
        document.setSaveTime(LocalDateTime.now());
        return documentRepo.save(document);
    }

    public Page<DocumentView> getPages(Optional<Integer> page, Optional<String> filter, Optional<Long> code) {
        if (filter.isPresent() && code.isPresent()) {
            String filterStr = filter.get();
            if (filterStr.equals("equals")) {
                return documentRepo.findAllByCodesOrderById(code.get(),getPageRequest(page));
            } else if (filterStr.equals("greater")) {
                return documentRepo.findAllDistinctByCodesGreaterThanOrderById(code.get(), getPageRequest(page));
            } else if (filterStr.equals("less")) {
                return documentRepo.findAllDistinctByCodesLessThanOrderById(code.get(), getPageRequest(page));
            } else {
                return documentRepo.findAllProjectedBy(getPageRequest(page));
            }
        }
        return documentRepo.findAllProjectedBy(getPageRequest(page));
    }

    private PageRequest getPageRequest(Optional<Integer> page) {
        return PageRequest.of(page.orElse(1) - 1, pageSize);
    }

    public Optional<Document> findOne(Long id) {
        return documentRepo.findById(id);
    }




    


   
    /*public Page<DocumentDtoListed> findAllPage(Optional<Integer> page) {
        Page<Document> entities = documentRepo.findAll(
                PageRequest.of(
                        page.orElse(0),
                        3,
                        Sort.Direction.ASC, "id"
                )
        );

        Page<DocumentDtoListed> dtoPage = entities.map(new Function<Document, DocumentDtoListed>() {
                                                   @Override
                                                   public DocumentDtoListed apply(Document entity) {
                                                       DocumentDtoListed dto = new DocumentDtoListed();
                                                       dto.setId(entity.getId());
                                                       dto.setName(entity.getName());
                                                       dto.setSaveTime(entity.getSaveTime());
                                                       dto.setCodes(entity.getCodes());
                                                       return dto;
                                                   }
        });
        return dtoPage;

    }*/

    /*public Page<DocumentDto> findAll(Pageable pageable) {
        Page<Document> page = documentRepo.findAll(pageable);
        return new PageImpl<>(page.getContent().stream()
                .map(document -> new DocumentDto(
                        document.getId(),
                        document.getName(),
                        document.getSaveTime(),
                        document.getCodes())).collect(Collectors.toList()),
                pageable, page.getTotalElements());
    }*/


}
