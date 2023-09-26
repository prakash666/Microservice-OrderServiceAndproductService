package com.mircoserviceorderservice.orderservice.dto;

import com.mircoserviceorderservice.orderservice.entity.OrderLineItem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDto {
    @NotBlank(message = "Enter Order number")
    private String orderNumber;
    @NotBlank(message = "Enter Order-Line Item list")
    @OneToMany(cascade = CascadeType.ALL)           // This is process of showing relationship with table
    private List<OrderLineItem> orderLineItemsList;
}
