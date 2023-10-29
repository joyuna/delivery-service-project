package com.joyuna.delivery.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PriceRequestDto {
    private List<OrderItemRequestDto> orderItemListDto;
}
