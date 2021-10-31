package com.example.documentsave.dto;

public class DocumentDtoInitial {
    private String name;
    private String text;

    public DocumentDtoInitial(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public DocumentDtoInitial() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
