package com.enotes.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.enotes.entity.Category;
import com.enotes.repository.CategoryRepository;
import com.enotes.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;

    public CategoryServiceImpl(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Boolean saveCategory(Category category) {
        category.setDeleted(false);
        category.setActive(true);
        category.setCreatedBy(1);
        category.setCreatedOn(new Date());

        Category saved = categoryRepo.save(category);
        return !ObjectUtils.isEmpty(saved);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }
}
