package com.mircoserviceorderservice.orderservice.controller;


import com.mircoserviceorderservice.orderservice.dto.OrderRequestDto;
import com.mircoserviceorderservice.orderservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }



    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequestDto orderRequestDto){
        orderService.placeOrder(orderRequestDto);
        return ResponseEntity.ok("Order place successfully");
    }










}
