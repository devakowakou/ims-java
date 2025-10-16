package com.Sindev.InventoryManagementSystem.services;

import com.Sindev.InventoryManagementSystem.dtos.CategoryDTO;
import com.Sindev.InventoryManagementSystem.dtos.Response;

public interface CategoryService {

    Response createCategory(CategoryDTO categoryDTO);

    Response getAllCategories();

    Response getCategoryById(Long id);

    Response updateCategory(Long id, CategoryDTO categoryDTO);

    Response deleteCategory(Long id);

}
