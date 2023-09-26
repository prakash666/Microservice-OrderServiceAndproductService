package com.project.InventoryService.dto;


import com.project.InventoryService.entity.InventoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDto {
    private Long id;
    private String skuCode;
    private Integer quantity;
}
