package com.productservice.productservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    @Id
    private String id;
    @NotBlank (message = "Enter first name")
    private String name;
    @NotBlank (message = "Enter description")
    private String description;
    @Min(value = 0)
    private Double price;
}
