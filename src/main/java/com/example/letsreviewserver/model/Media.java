package com.example.letsreviewserver.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "media")
@Data
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediaId;

    private String subject;
    private String filePath;
    private String originalName;
    private LocalDateTime createdAt = LocalDateTime.now();
}
