package com.project.InventoryService.configuration;


import com.project.InventoryService.entity.InventoryEntity;
import com.project.InventoryService.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryBean {

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository){
        return args -> {

            InventoryEntity inventoryEntity = new InventoryEntity();
            inventoryEntity.setSkuCode("Iphone-15");
            inventoryEntity.setQuantity(100);
            inventoryRepository.save(inventoryEntity);

            InventoryEntity inventoryEntity1 = new InventoryEntity();
            inventoryEntity1.setSkuCode("Iphone-14");
            inventoryEntity1.setQuantity(0);
            inventoryRepository.save(inventoryEntity1);
        };
    }
}
