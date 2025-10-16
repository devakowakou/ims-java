package com.Sindev.InventoryManagementSystem.services.impl;

import com.Sindev.InventoryManagementSystem.dtos.CategoryDTO;
import com.Sindev.InventoryManagementSystem.dtos.Response;
import com.Sindev.InventoryManagementSystem.exceptions.NotFoundException;
import com.Sindev.InventoryManagementSystem.models.Category;
import com.Sindev.InventoryManagementSystem.repositories.CategoryRepository;
import com.Sindev.InventoryManagementSystem.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    @Override
    public Response createCategory(CategoryDTO categoryDTO) {
        Category categoryToSave = modelMapper.map(categoryDTO,Category.class);

        categoryRepository.save(categoryToSave);

        return Response.builder()
                .status(200)
                .message("Category Saved Successfully")
                .build();
    }

    @Override
    public Response getAllCategories() {
        List<Category> categories = categoryRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        categories.forEach(category -> category.setProducts(null));
        List<CategoryDTO> categoryDTOList = modelMapper.map(categories, new TypeToken<>() {}.getType());

        return Response.builder()
                .status(200)
                .message("success")
                .categories(categoryDTOList)
                .build();
    }

    @Override
    public Response getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()->new NotFoundException("Category Not Found"));
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);

        return Response.builder()
                .status(200)
                .message("success")
                .category(categoryDTO)
                .build();
    }

    @Override
    public Response updateCategory(Long id, CategoryDTO categoryDTO) {
        Category existingCategory = categoryRepository.findById(id).
                orElseThrow(()->new NotFoundException("Category Not Found"));

        existingCategory.setName(categoryDTO.getName());
        categoryRepository.save(existingCategory);

        return Response.builder()
                .status(200)
                .message("Category Was Successfully Updated")
                .category(categoryDTO)
                .build();
    }

    @Override
    public Response deleteCategory(Long id) {
        Category existingCategory = categoryRepository.findById(id).
                orElseThrow(()->new NotFoundException("Category Not Found"));

        categoryRepository.delete(existingCategory);

        return Response.builder()
                .status(200)
                .message("Category Was Successfully Deleted")
                .build();
    }
}
