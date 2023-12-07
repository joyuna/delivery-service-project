package com.joyuna.delivery.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ItemPriceResponse {
    private final Long itemId;
    private final Integer price;

    public ItemPriceResponse(Long itemId, Integer price) {
        this.itemId = itemId;
        this.price = price;
    }
}
