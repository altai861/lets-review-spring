package com.example.letsreviewserver.place;

import com.example.letsreviewserver.auth.AuthUtil;
import com.example.letsreviewserver.country.district.DistrictRepository;
import com.example.letsreviewserver.dto.media.MediaResponseDTO;
import com.example.letsreviewserver.dto.place.PlaceRequestDTO;
import com.example.letsreviewserver.dto.place.PlaceResponseDTO;
import com.example.letsreviewserver.model.*;
import com.example.letsreviewserver.model.composite.PlaceMediaId;
import com.example.letsreviewserver.upload.MediaRepository;
import com.example.letsreviewserver.user.UserRepository;
import com.example.letsreviewserver.util.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final DistrictRepository districtRepository;
    private final PlaceRepository placeRepository;
    private final UserRepository userRepository;
    private final AuthUtil authUtil;
    private final MediaRepository mediaRepository;
    private final PlaceMediaRepository placeMediaRepository;

    @Transactional(readOnly = true)
    public List<PlaceResponseDTO> getFilteredPlaces(Long countryId, Long provinceId, Long districtId) {

        List<Place> places = placeRepository.findFilteredPlaces(districtId, provinceId, countryId);

        // Convert the list of entities to DTOs
        return places.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long createPlace(PlaceRequestDTO request) {
        District district = districtRepository.findById(request.getDistrictId()).orElseThrow(() -> new ResourceNotFoundException("District not found"));

        Date now = new Date();

        Long userId = 0L;

        String username = authUtil.getCurrentUsername();

        if (username != null) {
            userId = userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
        }

        Place place = Place.builder()
                .placeName(request.getPlaceName())
                .description(request.getDescription())
                .address(request.getAddress())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .floorNumber(request.getFloorNumber())
                .district(district) // Link the District
                .createdDatetime(now)
                .createdBy(userId)
                .modifiedDatetime(now)
                .modifiedBy(userId)
                .build();

        Place savedPlace = placeRepository.save(place);

        if (request.getMediaIds() != null && !request.getMediaIds().isEmpty()) {
            linkMediaToPlace(savedPlace, request.getMediaIds());
        }

        return savedPlace.getPlaceId();
    }

    @Transactional(readOnly = true)
    public PlaceResponseDTO getPlaceById(Long placeId) {
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> new ResourceNotFoundException("Place not found with ID: " + placeId));

        // Reusing the mapping logic from the previous GET endpoint
        return convertToDto(place);
    }

    private void linkMediaToPlace(Place place, List<Long> mediaIds) {
        List<PlaceMedia> placeMediaList = mediaIds.stream()
                .distinct() // Avoid duplicate links
                .map(mediaId -> {
                    Media media = mediaRepository.findById(mediaId)
                            .orElseThrow(() -> new ResourceNotFoundException("Media not found with ID: " + mediaId));

                    return PlaceMedia.builder()
                            .id(new PlaceMediaId(place.getPlaceId(), mediaId))
                            .place(place)
                            .media(media)
                            .createdDatetime(new Date())
                            .build();
                })
                .collect(Collectors.toList());

        placeMediaRepository.saveAll(placeMediaList);
    }

    @Transactional
    public PlaceResponseDTO updatePlace(Long placeId, PlaceRequestDTO request) {
        // 1. Find existing Place
        Place existingPlace = placeRepository.findById(placeId)
                .orElseThrow(() -> new ResourceNotFoundException("Place not found with ID: " + placeId));

        // 2. Find new District (if different)
        District newDistrict = districtRepository.findById(request.getDistrictId())
                .orElseThrow(() -> new ResourceNotFoundException("District not found with ID: " + request.getDistrictId()));

        // 3. Apply updates
        Long userId = 0L;

        String username = authUtil.getCurrentUsername();

        if (username != null) {
            userId = userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
        }

        existingPlace.setPlaceName(request.getPlaceName());
        existingPlace.setDescription(request.getDescription());
        existingPlace.setAddress(request.getAddress());
        existingPlace.setLatitude(request.getLatitude());
        existingPlace.setLongitude(request.getLongitude());
        existingPlace.setFloorNumber(request.getFloorNumber());
        existingPlace.setDistrict(newDistrict); // Update the district link

        // Update audit fields
        existingPlace.setModifiedDatetime(new Date());
        existingPlace.setModifiedBy(userId);

        updatePlaceMedia(existingPlace, request.getMediaIds());

        Place updatedPlace = placeRepository.save(existingPlace);
        return convertToDto(updatedPlace);
    }

    @Transactional
    protected void updatePlaceMedia(Place place, List<Long> newMediaIds) {

        if (newMediaIds == null) {
            newMediaIds = List.of();
        }

        List<PlaceMedia> existingMediaLinks = placeMediaRepository.findByPlace_PlaceId(place.getPlaceId());

        Set<Long> existingIds = existingMediaLinks.stream()
                .map(pm -> pm.getMedia().getMediaId())
                .collect(Collectors.toSet());

        Set<Long> updatedIds = new HashSet<>(newMediaIds);

        Set<Long> toAdd = updatedIds.stream()
                .filter(id -> !existingIds.contains(id))
                .collect(Collectors.toSet());

        Set<Long> toRemove = existingIds.stream()
                .filter(id -> !updatedIds.contains(id))
                .collect(Collectors.toSet());

        for (Long mediaId : toAdd) {
            Media media = mediaRepository.findById(mediaId)
                    .orElseThrow(() -> new ResourceNotFoundException("Media not found with ID: " + mediaId));

            PlaceMedia pm = PlaceMedia.builder()
                    .id(new PlaceMediaId(place.getPlaceId(), mediaId))
                    .place(place)
                    .media(media)
                    .createdDatetime(new Date())
                    .build();

            placeMediaRepository.save(pm);
        }

        // --- REMOVE OLD MEDIA ---
        if (!toRemove.isEmpty()) {
            placeMediaRepository.deleteByPlace_PlaceIdAndMedia_MediaIdIn(place.getPlaceId(), toRemove);
        }
    }

    @Transactional
    public void deletePlace(Long placeId) {
        if (!placeRepository.existsById(placeId)) {
            throw new ResourceNotFoundException("Place not found with ID: " + placeId);
        }
        placeRepository.deleteById(placeId);
    }

    private MediaResponseDTO convertMediaToDto(Media media) {
        return MediaResponseDTO.builder()
                .mediaId(media.getMediaId())
                .subject(media.getSubject())
                .filePath(media.getFilePath())
                .originalFilename(media.getOriginalName())
                .createdAt(media.getCreatedAt())
                .build();
    }

    private PlaceResponseDTO convertToDto(Place place) {
        // Accessing related entities (District, Province, Country) within the transaction
        // to get their IDs for the DTO.
        Long districtId = place.getDistrict().getDistrictId();
        Long provinceId = place.getDistrict().getProvince().getProvinceId();
        Long countryId = place.getDistrict().getProvince().getCountry().getCountryId();

        List<MediaResponseDTO> mediaList = placeMediaRepository.findMediaByPlaceId(place.getPlaceId()).stream()
                .map(PlaceMedia::getMedia)
                .map(this::convertMediaToDto)
                .collect(Collectors.toList());

        return PlaceResponseDTO.builder()
                .placeId(place.getPlaceId())
                .placeName(place.getPlaceName())
                .description(place.getDescription())
                .address(place.getAddress())
                .latitude(place.getLatitude())
                .longitude(place.getLongitude())
                .floorNumber(place.getFloorNumber())

                .districtId(districtId)
                .provinceId(provinceId)
                .countryId(countryId)

                .createdDatetime(place.getCreatedDatetime())
                .createdBy(place.getCreatedBy())
                .modifiedDatetime(place.getModifiedDatetime())
                .modifiedBy(place.getModifiedBy())

                .mediaList(mediaList)
                .build();
    }
}
