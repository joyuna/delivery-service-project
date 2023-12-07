package com.joyuna.delivery.domain.order.dto;

import com.joyuna.delivery.domain.item.Item;
import com.joyuna.delivery.domain.order.Order;
import com.joyuna.delivery.domain.order.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemAddRequest {
    private Long itemId;
    private Integer count;

    public OrderItem toEntity(Order order, int itemPrice) {
        return OrderItem.builder()
                .item(new Item(itemId))
                .order(order)
                .count(count)
                .orderPrice(itemPrice * count)
                .build();
    }
}
