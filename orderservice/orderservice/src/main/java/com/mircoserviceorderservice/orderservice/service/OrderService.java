package com.mircoserviceorderservice.orderservice.service;

import com.mircoserviceorderservice.orderservice.dto.OrderRequestDto;
import com.mircoserviceorderservice.orderservice.entity.OrderEntity;
import com.mircoserviceorderservice.orderservice.entity.OrderLineItem;
import com.mircoserviceorderservice.orderservice.repository.OrderRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void placeOrder(OrderRequestDto orderRequestDto) {

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItem> orderLineItemList = orderRequestDto.getOrderLineItemsList()
                .stream()
                .map(this::mapToDto)
                .toList();

        orderEntity.setOrderLineItemsList(orderLineItemList);

        orderRepository.save(orderEntity);

//        OrderEntity orderEntity = OrderEntity.builder()
//                .orderNumber(orderRequestDto.getOrderNumber())
//                .orderLineItemsList(orderRequestDto.getOrderLineItemsList()).
//                build();
//
//        orderRepository.save(orderEntity);
    }

    private OrderLineItem mapToDto(OrderLineItem orderLineItem) {
        OrderLineItem orderLineItem1 = new OrderLineItem();
        orderLineItem1.setPrice(orderLineItem.getPrice());
        orderLineItem1.setQuantity(orderLineItem.getQuantity());
        orderLineItem1.setSkuCode(orderLineItem.getSkuCode());
        return orderLineItem1;
    }
}
