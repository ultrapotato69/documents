package com.example.documentsave.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Set;

public interface DocumentView {
    Long getId();
    String getName();
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    LocalDateTime getSaveTime();
    Set<Long> getCodes();
}
