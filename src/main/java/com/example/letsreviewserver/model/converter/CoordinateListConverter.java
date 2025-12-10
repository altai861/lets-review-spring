package com.example.letsreviewserver.model.converter;

import com.example.letsreviewserver.model.nondb.Coordinate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.ArrayList;
import java.util.List;

@Converter
public class CoordinateListConverter implements AttributeConverter<List<Coordinate>, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<Coordinate> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert coordinates to JSON", e);
        }
    }

    @Override
    public List<Coordinate> convertToEntityAttribute(String dbData) {
        try {
            if (dbData == null || dbData.isEmpty()) return new ArrayList<>();
            return objectMapper.readValue(dbData, new TypeReference<List<Coordinate>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert json to coordinates", e);
        }
    }
}
