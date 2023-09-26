package com.productservice.productservice.entity;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document (value = "product")
public class Product {
    @Id
    private String id;
    @NotBlank (message = "Enter name")
    private String name;
    @NotBlank (message = "Enter description")
    private String description;
    @Min(value = 0)
    private Double price;
}
