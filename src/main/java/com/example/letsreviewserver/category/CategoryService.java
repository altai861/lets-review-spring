package com.example.letsreviewserver.category;

import com.example.letsreviewserver.auth.AuthUtil;
import com.example.letsreviewserver.dto.category.CategoryResponse;
import com.example.letsreviewserver.dto.category.CreateCategoryRequest;
import com.example.letsreviewserver.model.Category;
import com.example.letsreviewserver.model.Media;
import com.example.letsreviewserver.model.User;
import com.example.letsreviewserver.upload.MediaRepository;
import com.example.letsreviewserver.user.UserRepository;
import com.example.letsreviewserver.util.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final MediaRepository mediaRepository;
    private final UserRepository userRepository;
    private final AuthUtil authUtil;

    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAllWithMedia();

        return categories.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CategoryResponse convertToDto(Category category) {
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

    public Long createCategory(CreateCategoryRequest request) {
        Media media = mediaRepository.findById(request.getMediaId()).orElseThrow(() -> new ResourceNotFoundException("Media not found"));

        Date now = new Date();

        Long userId = 0L;

        String username = authUtil.getCurrentUsername();

        if (username != null) {
            userId = userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
        }

        Category category = Category.builder()
                .categoryName(request.getCategoryName())
                .categoryDescription(request.getCategoryDescription())
                .media(media)
                .createdDatetime(now)
                .createdBy(userId)
                .modifiedDatetime(now)
                .modifiedBy(userId)
                .build();

        Category savedCategory = categoryRepository.save(category);

        return savedCategory.getCategoryId();

    }

    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        return convertToDto(category);
    }

    public CategoryResponse updateCategory(Long categoryId, CreateCategoryRequest request) {
        Category existingCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Media newMedia = mediaRepository.findById(request.getMediaId()).orElseThrow(() -> new ResourceNotFoundException("Media not found"));

        Date now = new Date();
        Long userId = 0L;

        String username = authUtil.getCurrentUsername();

        if (username != null) {
            userId = userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
        }

        existingCategory.setCategoryName(request.getCategoryName());
        existingCategory.setCategoryDescription(request.getCategoryDescription());
        existingCategory.setMedia(newMedia);
        existingCategory.setModifiedDatetime(now);
        existingCategory.setModifiedBy(userId);

        Category updatedCategory = categoryRepository.save(existingCategory);
        return convertToDto(updatedCategory);
    }

    public void deleteCategory(Long categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new ResourceNotFoundException("Category not found");
        }

        categoryRepository.deleteById(categoryId);
    }
}
