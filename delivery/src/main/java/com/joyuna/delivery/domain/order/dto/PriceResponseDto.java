package com.joyuna.delivery.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PriceResponseDto {
    private Long itemId;
    private Integer price;
}
