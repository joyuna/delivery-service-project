package com.joyuna.delivery.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TotalPriceRequest {
    private List<OrderItemAddRequest> orderItemList;
}
