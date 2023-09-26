package com.project.InventoryService.repository;

import com.project.InventoryService.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryEntity,Long> {
    Optional<InventoryEntity> findBySkuCode(String SkuCode);
}
