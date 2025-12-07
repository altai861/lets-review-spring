package com.example.letsreviewserver.util.mapper;

import com.example.letsreviewserver.dto.media.MediaResponseDTO;
import com.example.letsreviewserver.model.Media;
import org.springframework.stereotype.Component;

@Component
public class MediaMapper {
    public MediaResponseDTO toDto(Media media) {
        if (media == null) return null;
        return MediaResponseDTO.builder()
                .mediaId(media.getMediaId())
                .subject(media.getSubject())
                .filePath(media.getFilePath())
                .originalFilename(media.getOriginalName())
                .createdAt(media.getCreatedAt())
                .build();
    }
}
