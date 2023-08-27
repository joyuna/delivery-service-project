package com.joyuna.delivery.domain.order;

import com.joyuna.delivery.domain.order.dto.OrderRequestDto;
import com.joyuna.delivery.domain.order.dto.OrderResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        return ResponseEntity.ok().body(orderService.save(orderRequestDto));
    }
}
