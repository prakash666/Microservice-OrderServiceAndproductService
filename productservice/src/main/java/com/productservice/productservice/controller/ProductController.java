package com.productservice.productservice.controller;

import com.productservice.productservice.dto.ProductRequest;
import com.productservice.productservice.dto.ProductResponse;
import com.productservice.productservice.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @PostMapping("/product")
    @ResponseStatus (HttpStatus.CREATED)
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
        return ResponseEntity.ok("Data has been posted");
    }


    @GetMapping("/get")
    @ResponseStatus (HttpStatus.OK)
    public List<ProductResponse> getDATA(){
        return productService.getData();
    }
}
