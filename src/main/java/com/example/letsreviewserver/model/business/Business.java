package com.example.letsreviewserver.model.business;

import com.example.letsreviewserver.model.District;
import com.example.letsreviewserver.model.Place;
import com.example.letsreviewserver.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "business")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long businessId;

    private String businessName;
    private String status;
    private String workingHours;
    private String address;
    private Double latitude;
    private Double longitude;
    private String email;
    private Integer floorNumber;
    private LocalDateTime createdDatetime;
    private Long createdBy;
    private LocalDateTime modifiedDatetime;
    private Long modifiedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "districtId", nullable = false)
    private District district;

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<BusinessMedia> businessMediaList = new HashSet<>();

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<BusinessCategory> businessCategoryList = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placeId")
    private Place place;
}
