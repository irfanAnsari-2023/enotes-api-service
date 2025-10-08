package com.enotes.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import com.enotes.entity.Category;
import com.enotes.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/save-category")
    public ResponseEntity<String> saveCategory(@RequestBody Category category) {
        boolean saved = categoryService.saveCategory(category);
        if (saved) {
            return new ResponseEntity<>("Category saved successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to save category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllCategory")
    public ResponseEntity<?> getAllCategory() {
        List<Category> categories = categoryService.getAllCategory();
        if (CollectionUtils.isEmpty(categories)) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
