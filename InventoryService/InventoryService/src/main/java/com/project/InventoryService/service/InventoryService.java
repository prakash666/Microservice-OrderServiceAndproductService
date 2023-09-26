package com.project.InventoryService.service;

import com.project.InventoryService.dto.InventoryDto;
import com.project.InventoryService.entity.InventoryEntity;
import com.project.InventoryService.exception.DefaultException;
import com.project.InventoryService.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;


    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
       return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }

    public List<InventoryEntity> getInventoryData(InventoryDto inventoryDto) {
        InventoryEntity inventoryEntity = InventoryEntity.builder()
                .id(inventoryDto.getId())
                .quantity(inventoryDto.getQuantity())
                .skuCode(inventoryDto.getSkuCode()).build();
        return inventoryRepository.findAll();
    }

    public InventoryEntity getSingleInventoryData(Long id) throws DefaultException {
        Optional<InventoryEntity> optionalInventoryEntity = inventoryRepository.findById(id);
        if (optionalInventoryEntity.isPresent()){
            return optionalInventoryEntity.get();
        } else{
            throw new DefaultException("Id not found!!");
        }
    }

    public void postData(InventoryDto inventoryDto) {
        InventoryEntity inventoryEntity = InventoryEntity.builder()
                .id(inventoryDto.getId())
                .skuCode(inventoryDto.getSkuCode())
                .quantity(inventoryDto.getQuantity())
                .build();
        inventoryRepository.save(inventoryEntity);
    }
}
