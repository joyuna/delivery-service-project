package com.joyuna.delivery.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PriceRequestDto {
    private List<OrderItemRequestDto> orderItemListDto;
}
