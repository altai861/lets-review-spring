package com.example.letsreviewserver.dto.category;

import lombok.Data;

@Data
public class CreateCategoryRequest {
    private String categoryName;
    private String categoryDescription;
    private Long mediaId;
}
