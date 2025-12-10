package com.example.letsreviewserver.model.service;

import com.example.letsreviewserver.model.business.Business;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    private String serviceName;
    private Double price;
    private String description;
    private Long availability;

    private LocalDateTime createdDatetime;
    private Long createdBy;
    private LocalDateTime modifiedDatetime;
    private Long modifiedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "businessId", nullable = false)
    private Business business;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<ServiceMedia> serviceMediaList = new HashSet<>();
}
