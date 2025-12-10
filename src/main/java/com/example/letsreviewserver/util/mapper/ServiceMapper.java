package com.example.letsreviewserver.util.mapper;

import com.example.letsreviewserver.dto.media.MediaResponseDTO;
import com.example.letsreviewserver.dto.service.ServiceResponseDTO;
import com.example.letsreviewserver.model.service.Service;
import com.example.letsreviewserver.model.service.ServiceMedia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ServiceMapper {
    private final MediaMapper mediaMapper;

    public ServiceResponseDTO toDto(Service s) {
        if (s == null) return null;

        List<MediaResponseDTO> media = s.getServiceMediaList().stream()
                .map(ServiceMedia::getMedia)
                .map(mediaMapper::toDto)
                .collect(Collectors.toList());

        return ServiceResponseDTO.builder()
                .serviceId(s.getServiceId())
                .serviceName(s.getServiceName())
                .price(s.getPrice())
                .description(s.getDescription())
                .availability(s.getAvailability())
                .businessId(s.getBusiness().getBusinessId())
                .media(media)
                .createdDatetime(s.getCreatedDatetime())
                .createdBy(s.getCreatedBy())
                .modifiedDatetime(s.getModifiedDatetime())
                .modifiedBy(s.getModifiedBy())
                .build();
    }
}
