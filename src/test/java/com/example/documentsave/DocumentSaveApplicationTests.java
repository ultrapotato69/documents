package com.example.documentsave;


import com.example.documentsave.domain.Document;
import com.example.documentsave.dto.DocumentDtoInitial;
import com.example.documentsave.dto.DocumentView;
import com.example.documentsave.repo.DocumentRepo;
import com.example.documentsave.service.DocumentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
class DocumentSaveApplicationTests {

    @Autowired
    DocumentRepo documentRepo;
    @Autowired
    DocumentService documentService;

    String testString = "Россия и Соединенные {123} Штаты должны найти необходимые {+5.17} сферы сотрудничества, {789 } " +
            "заявила на брифинге {7- } официальный {56749} представиттель госдепа Хизер {+55844} Науэрт, " +
            "комментируя слова {-78914} российского премьер-министра  {0.22356} Дмитрия Медведева" +
            " об отношениях {ok} между Москвой и Васшингтоном. {4}";
    String testString2 = "{123} Штаты должны найти необходимые {2021} " +
            "заявила на брифинге {7- } официальный {-900} представиттель госдепа Хизер {+55844} Науэрт, " +
            "комментируя слова {-78914} российского {-80001} премьер-министра  {0.22356} Дмитрия Медведева" +
            " об отношениях {ok} между Москвой и Васшингтоном. {4}";

    @Test
    void saveTest()
    {
        Document document = new Document();
        document.setName("num1");
        document.setText("text");
        document.setSaveTime(LocalDateTime.now());
        Set<Long> codes =  new HashSet<>();
        codes.add(5L);
        codes.add(10L);
        document.setCodes(codes);
        documentRepo.save(document);
    }


    @Test
    void saveDto() {
        DocumentDtoInitial dtoInitial1 = new DocumentDtoInitial("testName1", testString);
        DocumentDtoInitial dtoInitial2 = new DocumentDtoInitial("testName2", testString2);
        documentService.save(dtoInitial1);
        documentService.save(dtoInitial2);
    }

    @Test
    void findAllProjected() {
        Page<DocumentView> allProjected = documentRepo.findAllProjectedBy(PageRequest.of(0, 3));
        allProjected.forEach(x -> {
            System.out.println("Document name: " + x.getName() + "\nCodes: ");
            x.getCodes().forEach(System.out::println);
        });
        System.out.println("\nTotal elements: " + allProjected.getTotalElements());
    }

    @Test
    public void shouldFindByCodes() {
        Page<DocumentView> allByCodes = documentRepo.findAllByCodesOrderById(4L,
                PageRequest.of(0, 2));
        allByCodes.forEach(x -> {
            System.out.println(x.getName());
            x.getCodes().forEach(System.out::println);
        });
        System.out.println("Test2");
        Page<DocumentView> allByCodes2 = documentRepo.findAllByCodesOrderById(123L,
                PageRequest.of(0, 2));
        allByCodes2.forEach(x -> {
            System.out.println(x.getName());
            x.getCodes().forEach(System.out::println);
        });
    }

    @Test
    void getPages() {
        Optional<Integer> page = Optional.of(0);
        Optional<String> filter = Optional.of("equals");
        Optional<Long> code = Optional.of(4L);
        Page<DocumentView> pages = documentService.getPages(page, filter, code);
        pages.forEach(x -> {
            System.out.println(x.getName() + "\n Codes:");
            x.getCodes().forEach(System.out::println);
        });
        System.out.println("\nTotal elements: " + pages.getTotalElements());
    }

    @Test
    public void shouldFindByCodesGreaterThan() {
        Page<DocumentView> allByCodes = documentRepo.findAllDistinctByCodesGreaterThanOrderById(56000L,
                PageRequest.of(0, 6));
        allByCodes.forEach(x -> {
            System.out.println(x.getName() + "\n Codes:");
            x.getCodes().forEach(System.out::println);
        });
        System.out.println("\nTotal elements" + allByCodes.getTotalElements());
    }
    @Test
    public void shouldFindByCodesLessThan() {
        Page<DocumentView> allByCodes = documentRepo.findAllDistinctByCodesLessThanOrderById(-80000L,
                PageRequest.of(0, 2));
        allByCodes.forEach(x -> {
            System.out.println(x.getName());
            x.getCodes().forEach(System.out::println);
        });
        System.out.println("\nTotal elements" + allByCodes.getTotalElements());
    }


}
