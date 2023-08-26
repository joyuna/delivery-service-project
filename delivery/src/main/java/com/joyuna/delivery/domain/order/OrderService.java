package com.joyuna.delivery.domain.order;

import com.joyuna.delivery.domain.order.dto.OrderRequestDto;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(OrderRequestDto orderRequestDto) {
        Order order = orderRepository.save(orderRequestDto.toEntity());
    }
}
