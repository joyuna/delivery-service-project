package com.joyuna.delivery.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
