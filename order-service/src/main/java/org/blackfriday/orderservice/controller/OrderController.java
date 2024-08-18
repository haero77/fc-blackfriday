package org.blackfriday.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.blackfriday.orderservice.dto.*;
import org.blackfriday.orderservice.entity.ProductOrder;
import org.blackfriday.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order/start-order")
    public StartOrderResponseDto startOrder(
            @RequestBody final StartOrderDto startOrderDto
    ) {

    }

    @PostMapping("/order/finish-order")
    public ProductOrder finishOrder(
            @RequestBody final FinishOrderDto finishOrderDto
    ) {

    }

    @GetMapping("/order/users/{userId}/orders")
    public List<ProductOrder> getUserOrders(@PathVariable Long userId) {

    }

    @GetMapping("/order/orders/{orderId}")
    public ProductOrderDetailDto getOrder(@PathVariable Long orderId) {

    }
}
