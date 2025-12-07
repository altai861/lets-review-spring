package com.example.letsreviewserver.service;

import com.example.letsreviewserver.model.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findByBusiness_BusinessId(Long businessId);
}
