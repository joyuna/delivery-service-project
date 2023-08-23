package com.joyuna.delivery.domain.item.dto;

import com.joyuna.delivery.domain.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemCreateRequestDto {
    private Long id;
    private String category;
    private String name;
    private Integer price;
    private Integer stock;
    private String saleStatus;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Item toEntity() {
        return Item.builder()
                .id(id)
                .category(category)
                .name(name)
                .price(price)
                .stock(stock)
                .saleStatus(saleStatus)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .build();
    }
}
