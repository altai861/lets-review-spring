package com.example.letsreviewserver.business;

import com.example.letsreviewserver.auth.AuthUtil;
import com.example.letsreviewserver.category.CategoryRepository;
import com.example.letsreviewserver.country.district.DistrictRepository;
import com.example.letsreviewserver.dto.business.BusinessCreateRequest;
import com.example.letsreviewserver.dto.business.BusinessResponseDTO;
import com.example.letsreviewserver.model.*;
import com.example.letsreviewserver.model.business.Business;
import com.example.letsreviewserver.model.business.BusinessCategory;
import com.example.letsreviewserver.model.business.BusinessMedia;
import com.example.letsreviewserver.place.PlaceRepository;
import com.example.letsreviewserver.upload.MediaRepository;
import com.example.letsreviewserver.user.UserRepository;
import com.example.letsreviewserver.util.exception.ResourceNotFoundException;
import com.example.letsreviewserver.util.mapper.BusinessMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusinessService {
    private final BusinessRepository businessRepository;
    private final DistrictRepository districtRepository;
    private final MediaRepository mediaRepository;
    private final BusinessMediaRepository businessMediaRepository;
    private final BusinessCategoryRepository businessCategoryRepository;
    private final CategoryRepository categoryRepository;
    private final BusinessMapper businessMapper;
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;
    private final AuthUtil authUtil;

    @Transactional(readOnly = true)
    public List<BusinessResponseDTO> getBusinesses(Long countryId, Long provinceId, Long districtId, Long categoryId) {
        List<Business> list = businessRepository.findWithFilters(countryId, provinceId, districtId, categoryId);
        return list.stream().map(businessMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public BusinessResponseDTO createBusiness(BusinessCreateRequest req) {
        District district = districtRepository.findById(req.getDistrictId())
                .orElseThrow(() -> new ResourceNotFoundException("District not found"));
        Optional<Place> place = Optional.empty();
        if (req.getPlaceId() != null) {
            place = placeRepository.findById(req.getPlaceId());
        }

        Long userId = 0L;
        User user = null;

        String username = authUtil.getCurrentUsername();

        if (username != null) {
            userId = userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
            user = userRepository.findById(userId).orElse(null);
        }

        Business b = Business.builder()
                .businessName(req.getBusinessName())
                .workingHours(req.getWorkingHours())
                .address(req.getAddress())
                .latitude(req.getLatitude())
                .longitude(req.getLongitude())
                .email(req.getEmail())
                .floorNumber(req.getFloorNumber() != null ? req.getFloorNumber() : null)
                .status("UNVERIFIED")
                .user(user)
                .createdDatetime(LocalDateTime.now())
                .createdBy(userId)
                .modifiedDatetime(LocalDateTime.now())
                .modifiedBy(userId)
                .district(district)
                .place(place.orElse(null))
                .build();

        Business saved = businessRepository.save(b);

        if (req.getMediaIds() != null && !req.getMediaIds().isEmpty()) {
            List<Media> medias = mediaRepository.findAllByMediaIdIn(req.getMediaIds());
            for (Media media : medias) {
                BusinessMedia bm = BusinessMedia.builder()
                        .business(saved)
                        .media(media)
                        .createdDatetime(LocalDateTime.now())
                        .createdBy(userId)
                        .build();
                businessMediaRepository.save(bm);
                saved.getBusinessMediaList().add(bm);
            }
        }

        if (req.getCategoryIds() != null && !req.getCategoryIds().isEmpty()) {
            List<Category> cats = categoryRepository.findAllById(req.getCategoryIds());
            for (Category c : cats) {
                BusinessCategory bc = BusinessCategory.builder()
                        .business(saved)
                        .category(c)
                        .build();
                businessCategoryRepository.save(bc);
                saved.getBusinessCategoryList().add(bc);
            }
        }

        return businessMapper.toDto(saved);
    }

    @Transactional(readOnly = true)
    public BusinessResponseDTO getBusiness(Long id) {
        Business business = businessRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Business not found"));
        return businessMapper.toDto(business);
    }

    @Transactional
    public BusinessResponseDTO updateBusiness(Long id, BusinessCreateRequest req) {

        Business business = businessRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Business not found"));

        District district = districtRepository.findById(req.getDistrictId())
                .orElseThrow(() -> new ResourceNotFoundException("District not found"));

        Place place = null;
        if (req.getPlaceId() != null) {
            place = placeRepository.findById(req.getPlaceId())
                    .orElse(null);
        }

        Long userId = 0L;
        User user = null;
        String username = authUtil.getCurrentUsername();
        if (username != null) {
            userId = userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
            user = userRepository.findById(userId).orElse(null);
        }

        business.setBusinessName(req.getBusinessName());
        business.setWorkingHours(req.getWorkingHours());
        business.setAddress(req.getAddress());
        business.setLatitude(req.getLatitude());
        business.setLongitude(req.getLongitude());
        business.setEmail(req.getEmail());
        business.setFloorNumber(req.getFloorNumber());
        business.setDistrict(district);

        business.setPlace(place);
        business.setUser(user);

        business.setModifiedBy(userId);
        business.setModifiedDatetime(LocalDateTime.now());

        updateBusinessMedia(business, req.getMediaIds());
        updateBusinessCategory(business, req.getCategoryIds());

        Business saved = businessRepository.save(business);
        return businessMapper.toDto(saved);
    }

    @Transactional
    public void deleteBusiness(Long id) {
        Business business = businessRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Business not found"));

        businessRepository.delete(business);
    }

    @Transactional
    protected void updateBusinessMedia(Business business, List<Long> mediaIds) {
        if (mediaIds == null) {
            mediaIds = List.of();
        }

        List<BusinessMedia> existingMediaLinks = businessMediaRepository.findByBusiness_BusinessId(business.getBusinessId());

        Set<Long> existingIds = existingMediaLinks.stream()
                .map(bm -> bm.getMedia().getMediaId())
                .collect(Collectors.toSet());

        Set<Long> updatedIds = new HashSet<>(mediaIds);

        Set<Long> toAdd = updatedIds.stream()
                .filter(id -> !existingIds.contains(id))
                .collect(Collectors.toSet());

        Set<Long> toRemove = existingIds.stream()
                .filter(id -> !updatedIds.contains(id))
                .collect(Collectors.toSet());

        for (Long mediaId : toAdd) {
            Media media = mediaRepository.findById(mediaId)
                    .orElseThrow(() -> new ResourceNotFoundException("Media not found"));
            BusinessMedia bm = BusinessMedia.builder()
                    .media(media)
                    .business(business)
                    .createdDatetime(LocalDateTime.now())
                    .build();

            businessMediaRepository.save(bm);
        }

        if (!toRemove.isEmpty()) {
            businessMediaRepository.deleteByBusiness_BusinessIdAndMedia_MediaIdIn(business.getBusinessId(), toRemove);
        }
    }


    @Transactional
    protected void updateBusinessCategory(Business business, List<Long> categoryIds) {
        if (categoryIds == null) {
            categoryIds = List.of();
        }

        List<BusinessCategory> existingCategoryLinks = businessCategoryRepository.findByBusiness_BusinessId(business.getBusinessId());

        Set<Long> existingIds = existingCategoryLinks.stream()
                .map(bc -> bc.getCategory().getCategoryId())
                .collect(Collectors.toSet());

        Set<Long> updatedIds = new HashSet<>(categoryIds);

        Set<Long> toAdd = updatedIds.stream()
                .filter(id -> !existingIds.contains(id))
                .collect(Collectors.toSet());

        Set<Long> toRemove = existingIds.stream()
                .filter(id -> !updatedIds.contains(id))
                .collect(Collectors.toSet());

        for (Long catId : toAdd) {
            Category cat = categoryRepository.findById(catId)
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
            BusinessCategory bc = BusinessCategory.builder()
                    .category(cat)
                    .business(business)
                    .build();

            businessCategoryRepository.save(bc);
        }

        if (!toRemove.isEmpty()) {
            businessCategoryRepository.deleteByBusiness_BusinessIdAndCategory_CategoryIdIn(business.getBusinessId(), toRemove);
        }
    }
}
