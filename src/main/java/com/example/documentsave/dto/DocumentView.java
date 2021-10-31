package com.example.documentsave.dto;

import java.time.LocalDateTime;
import java.util.Set;

public interface DocumentView {
    Long getId();
    String getName();
    LocalDateTime getSaveTime();
    Set<Long> getCodes();
}
