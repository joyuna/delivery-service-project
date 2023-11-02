package com.joyuna.delivery.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPriceResponse {
    private Long itemId;
    private Integer price;
}
