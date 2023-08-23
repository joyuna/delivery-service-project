package com.joyuna.delivery.domain.item.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemUpdateRequestDto {
    private String category;
    private String name;
    private Integer price;
    private Integer stock;
    private String saleStatus;
}
