package com.mircoserviceorderservice.orderservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLineItemDto {
    @NotBlank(message = "Cannot be Blank")
    private String skuCode;
    private Double price;
    private Integer quantity;
}
