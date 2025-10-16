package com.Sindev.InventoryManagementSystem.services;

import com.Sindev.InventoryManagementSystem.dtos.ProductDTO;
import com.Sindev.InventoryManagementSystem.dtos.Response;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    Response saveProduct(ProductDTO productDTO, MultipartFile imageFile);

    Response updateProduct(ProductDTO productDTO, MultipartFile imageFile);

    Response getAllProducts();

    Response getProductById(Long id);

    Response deleteProduct(Long id);

    Response searchProduct(String input);
}
