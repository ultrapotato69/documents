package com.example.documentsave.domain;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Document {
    @Id
    @GeneratedValue(generator = "document_sequence")
    private Long id;
    private String name;
    @Column(columnDefinition="text")
    private String text;
    private LocalDateTime saveTime;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "code")
    private Set<Long> codes;


    public Document() {
    }

    public Document(Long id, String name, String text, LocalDateTime saveTime, Set<Long> codes) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.saveTime = saveTime;
        this.codes = codes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(LocalDateTime saveTime) {
        this.saveTime = saveTime;
    }

    public Set<Long> getCodes() {
        return codes;
    }

    public void setCodes(Set<Long> codes) {
        this.codes = codes;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", saveTime=" + saveTime +
                '}';
    }
}
