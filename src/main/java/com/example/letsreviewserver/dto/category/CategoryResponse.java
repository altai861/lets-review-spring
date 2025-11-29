package com.example.letsreviewserver.dto.category;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CategoryResponse {
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;

    private String iconFilePath;

    private Date createdDatetime;
    private Long createdBy;
    private Date modifiedDatetime;
    private Long modifiedBy;
}
