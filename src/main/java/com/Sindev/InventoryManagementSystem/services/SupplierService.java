package com.Sindev.InventoryManagementSystem.services;

import com.Sindev.InventoryManagementSystem.dtos.Response;
import com.Sindev.InventoryManagementSystem.dtos.SupplierDTO;

public interface SupplierService {
    Response addSupplier(SupplierDTO supplierDTO);

    Response updateSupplier(Long id, SupplierDTO supplierDTO);

    Response getAllSupplier();

    Response getSupplierById(Long id);

    Response deleteSupplier(Long id);

}
