package com.mircoserviceorderservice.orderservice.entity;

import jakarta.persistence.*;
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
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Enter order number")
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)           // This is process of showing relationship with table
    private List<OrderLineItem> orderLineItemsList;

}
