package com.example.letsreviewserver.service;

import com.example.letsreviewserver.auth.AuthUtil;
import com.example.letsreviewserver.business.BusinessRepository;
import com.example.letsreviewserver.dto.service.CreateServiceRequest;
import com.example.letsreviewserver.dto.service.ServiceResponseDTO;

import com.example.letsreviewserver.model.Media;
import com.example.letsreviewserver.model.User;
import com.example.letsreviewserver.model.business.Business;
import com.example.letsreviewserver.model.service.Service;
import com.example.letsreviewserver.model.service.ServiceMedia;
import com.example.letsreviewserver.place.PlaceRepository;
import com.example.letsreviewserver.upload.MediaRepository;
import com.example.letsreviewserver.user.UserRepository;
import com.example.letsreviewserver.util.exception.ResourceNotFoundException;
import com.example.letsreviewserver.util.mapper.ServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceService {
    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;
    private final BusinessRepository businessRepository;
    private final UserRepository userRepository;
    private final AuthUtil authUtil;
    private final MediaRepository mediaRepository;
    private final ServiceMediaRepository serviceMediaRepository;


    @Transactional(readOnly = true)
    public List<ServiceResponseDTO> getServiceByBusinessId(Long businessId) {
        if (!businessRepository.existsById(businessId)) {
            throw new ResourceNotFoundException("Business with id " + businessId + " not found");
        }
        List<Service> services = serviceRepository.findByBusiness_BusinessId(businessId);

        return services.stream()
                .map(serviceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ServiceResponseDTO createBusinessService(Long businessId, CreateServiceRequest req) {
        System.out.println(req.getServiceName() + req.getPrice() + req.getDescription() + req.getAvailability() + req.getMediaIds());
        Business business = businessRepository.findById(businessId)
                .orElseThrow(() -> new ResourceNotFoundException("Business Not Found"));

        Long userId;

        String username = authUtil.getCurrentUsername();

        if (username != null) {
            userId = userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
        } else {
            userId = 0L;
        }

        Service s = Service.builder()
                .serviceName(req.getServiceName())
                .price(req.getPrice())
                .description(req.getDescription())
                .availability(req.getAvailability())
                .createdDatetime(LocalDateTime.now())
                .createdBy(userId)
                .modifiedDatetime(LocalDateTime.now())
                .modifiedBy(userId)
                .business(business)
                .build();

        if (req.getMediaIds() != null && !req.getMediaIds().isEmpty()) {
            List<Media> medias = mediaRepository.findAllById(req.getMediaIds());

            Set<ServiceMedia> serviceMediaLinks = medias.stream()
                    .map(media -> ServiceMedia.builder()
                            .service(s)
                            .media(media)
                            .createdDatetime(LocalDateTime.now())
                            .createdBy(userId)
                            .build())
                    .collect(Collectors.toSet());

            s.setServiceMediaList(serviceMediaLinks);
        }

        Service saved = serviceRepository.save(s);

        return serviceMapper.toDto(saved);
    }

    public ServiceResponseDTO getServiceById(Long id) {
        Service s = serviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service Not Found"));
        return serviceMapper.toDto(s);
    }

    public ServiceResponseDTO updateService(Long id, CreateServiceRequest req) {
        Service s = serviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service Not Found"));

        Long userId = 0L;

        String username = authUtil.getCurrentUsername();

        if (username != null) {
            userId = userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
        }

        s.setServiceName(req.getServiceName());
        s.setPrice(req.getPrice());
        s.setDescription(req.getDescription());
        s.setAvailability(req.getAvailability());

        s.setModifiedDatetime(LocalDateTime.now());
        s.setModifiedBy(userId);

        handleMediaUpdate(s, req.getMediaIds(), userId);

        Service updatedService = serviceRepository.save(s);
        return serviceMapper.toDto(updatedService);
    }

    @Transactional
    public void deleteService(Long id) {
        if (!serviceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Service Not Found");
        }

        serviceRepository.deleteById(id);
    }

    private void handleMediaUpdate(Service service, List<Long> mediaIds, Long userId) {
        if (mediaIds == null || mediaIds.isEmpty()) {
            service.getServiceMediaList().clear();
            return;
        }

        Set<Long> currentMediaIds = service.getServiceMediaList().stream()
                .map(sm -> sm.getMedia().getMediaId())
                .collect(Collectors.toSet());

        service.getServiceMediaList().removeIf(sm -> !mediaIds.contains(sm.getMedia().getMediaId()));

        List<Long> mediaIdsToAdd = mediaIds.stream()
                .filter(id -> !currentMediaIds.contains(id))
                .collect(Collectors.toList());

        if (!mediaIdsToAdd.isEmpty()) {
            List<Media> newMediaEntities = mediaRepository.findAllById(mediaIdsToAdd);

            Set<ServiceMedia> newServiceMediaLinks = newMediaEntities.stream()
                    .map(media -> ServiceMedia.builder()
                            .service(service)
                            .media(media)
                            .createdDatetime(LocalDateTime.now())
                            .createdBy(userId)
                            .build())
                    .collect(Collectors.toSet());

            service.getServiceMediaList().addAll(newServiceMediaLinks);
        }
    }
}
