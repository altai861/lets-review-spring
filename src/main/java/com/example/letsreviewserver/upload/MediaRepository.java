package com.example.letsreviewserver.upload;

import com.example.letsreviewserver.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
    List<Media> findAllByMediaIdIn(List<Long> ids);
}
