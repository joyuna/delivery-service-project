package com.joyuna.delivery.domain.order.dto;

import com.joyuna.delivery.domain.order.Order;
import com.joyuna.delivery.domain.order.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
    private List<OrderItemRequestDto> orderItemsDto;
    private String receiverName;
    private String receiverTel;
    private String receiverAddress;

    public Order toEntity() {
        List<OrderItem> orderItems = new ArrayList<>();
        for(OrderItemRequestDto orderItemDto : orderItemsDto) {
            OrderItem orderItem = orderItemDto.toEntity();
            orderItems.add(orderItem);
        }
        return Order.builder()
                .receiverName(receiverName)
                .receiverTel(receiverTel)
                .receiverAddress(receiverAddress)
                .orderItems(orderItems)
                .build();
    }
}
