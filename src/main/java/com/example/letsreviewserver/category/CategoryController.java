package com.example.letsreviewserver.category;

import com.example.letsreviewserver.dto.category.AssignMetricToCategoryResponse;
import com.example.letsreviewserver.dto.category.CategoryMetricResponse;
import com.example.letsreviewserver.dto.category.CategoryResponse;
import com.example.letsreviewserver.dto.category.CreateCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMetricService categoryMetricService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        List<CategoryResponse> categories = categoryService.getAllCategories();
        return ResponseEntity.ok().body(categories);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addCategory(@RequestBody CreateCategoryRequest request) {
        Long newCategoryId = categoryService.createCategory(request);

        Map<String, Object> response = new HashMap<>();
        response.put("categoryId", newCategoryId);
        response.put("message", "Category added");

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable Long id) {
        CategoryResponse category = categoryService.getCategoryById(id);
        return ResponseEntity.ok().body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Long id, @RequestBody CreateCategoryRequest request) {
        CategoryResponse updatedCategory = categoryService.updateCategory(id, request);
        return ResponseEntity.ok().body(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "category deleted");
        return ResponseEntity.ok().body(response);
    }

    // Category Metric Connection APIs
    @PostMapping("/{categoryId}/metrics/{metricId}")
    public ResponseEntity<AssignMetricToCategoryResponse> assignMetric(
            @PathVariable Long categoryId,
            @PathVariable Long metricId
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryMetricService.assignMetric(categoryId, metricId));
    }

    @GetMapping("/{categoryId}/metrics")
    public ResponseEntity<List<CategoryMetricResponse>> getMetrics(
            @PathVariable Long categoryId
    ) {
        return ResponseEntity.ok(categoryMetricService.getMetricsOfCategory(categoryId));
    }

    @DeleteMapping("/{categoryId}/metrics/{metricId}")
    public ResponseEntity<?> removeMetric(
            @PathVariable Long categoryId,
            @PathVariable Long metricId
    ) {
        categoryMetricService.removeMetricFromCategory(categoryId, metricId);
        return ResponseEntity.ok().body(
                "{\"message\": \"Metric removed from category\"}"
        );
    }
}
