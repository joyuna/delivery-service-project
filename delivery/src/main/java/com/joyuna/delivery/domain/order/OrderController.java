package com.joyuna.delivery.domain.order;

import com.joyuna.delivery.domain.order.dto.OrderCreateRequest;
import com.joyuna.delivery.domain.order.dto.OrderCreateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderCreateResponse> createOrder(@RequestBody OrderCreateRequest request) {
        return ResponseEntity.ok().body(orderService.createOrder(request));
    }
}
