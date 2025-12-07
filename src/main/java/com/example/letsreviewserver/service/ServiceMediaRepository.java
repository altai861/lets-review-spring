package com.example.letsreviewserver.service;

import com.example.letsreviewserver.model.service.ServiceMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceMediaRepository extends JpaRepository<ServiceMedia, Long> {
}
