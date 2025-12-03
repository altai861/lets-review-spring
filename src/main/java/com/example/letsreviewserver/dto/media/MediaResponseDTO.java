package com.example.letsreviewserver.dto.media;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MediaResponseDTO {
    private Long mediaId;
    private String subject;
    private String filePath;
    private String originalFilename;
    private LocalDateTime createdAt;
}
