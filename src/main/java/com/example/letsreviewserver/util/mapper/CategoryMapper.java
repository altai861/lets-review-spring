package com.example.letsreviewserver.util.mapper;

import com.example.letsreviewserver.dto.category.CategoryResponse;
import com.example.letsreviewserver.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapper {
    public CategoryResponse toDto(Category category) {
        if (category == null) {
            return null;
        }

        String filePath = category.getMedia() != null ? category.getMedia().getFilePath() : null;

        return CategoryResponse.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .categoryDescription(category.getCategoryDescription())
                .iconFilePath(filePath)
                .createdDatetime(category.getCreatedDatetime())
                .createdBy(category.getCreatedBy())
                .modifiedDatetime(category.getModifiedDatetime())
                .modifiedBy(category.getModifiedBy())
                .build();
    }
}
