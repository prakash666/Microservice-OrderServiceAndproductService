package com.project.InventoryService.controller;
import com.project.InventoryService.dto.InventoryDto;
import com.project.InventoryService.entity.InventoryEntity;
import com.project.InventoryService.exception.DefaultException;
import com.project.InventoryService.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping ("/{sku-code}")
    @ResponseStatus (HttpStatus.OK)
    public boolean isInStock(@PathVariable ("sku-code") String skuCode){
        return inventoryService.isInStock(skuCode);

    }



    @GetMapping ("/get")
    public List<InventoryEntity> getInventoryData(@PathVariable InventoryDto inventoryDto){
        return inventoryService.getInventoryData(inventoryDto);
    }



    @GetMapping("/getSingle/{id}")
    public InventoryEntity getSingleInventoryData(@PathVariable ("id") Long id) throws DefaultException {
        return inventoryService.getSingleInventoryData(id);
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/post")
    public String postData(@RequestBody  InventoryDto inventoryDto){
        inventoryService.postData(inventoryDto);
        return "Data has been posted";
    }





}
