package com.Sindev.InventoryManagementSystem.repositories;

import com.Sindev.InventoryManagementSystem.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
}
