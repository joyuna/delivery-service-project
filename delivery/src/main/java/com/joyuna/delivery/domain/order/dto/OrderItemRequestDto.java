package com.joyuna.delivery.domain.order.dto;

import com.joyuna.delivery.domain.item.Item;
import com.joyuna.delivery.domain.order.OrderItem;

public class OrderItemRequestDto {
    private Long itemId;
    private Integer count;

    public OrderItem toEntity() {
        return OrderItem.builder()
                .item(new Item(itemId))
                .count(count)
                .build();
    }
}
