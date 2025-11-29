package com.example.letsreviewserver.upload;

import com.example.letsreviewserver.model.Media;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MediaService {
    private final MediaRepository mediaRepository;

    public Media saveMedia(MultipartFile file, String subject) throws IOException {
        String date = LocalDate.now().toString();
        String uploadDir = "uploads/" + subject + "/" + date;

        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        String uuid = UUID.randomUUID().toString();
        String fileName = uuid + "_" + file.getOriginalFilename();

        Path filePath = Paths.get(uploadDir, fileName);
        Files.write(filePath, file.getBytes());

        String publicFilePath = "/uploads/" + subject + "/" + date + "/" + fileName;

        Media media = new Media();
        media.setSubject(subject);
        media.setOriginalName(file.getOriginalFilename());
        media.setFilePath(publicFilePath);

        return mediaRepository.save(media);
    }
}
