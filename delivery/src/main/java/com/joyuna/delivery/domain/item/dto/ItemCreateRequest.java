package com.joyuna.delivery.domain.item.dto;

import com.joyuna.delivery.domain.item.Item;
import com.joyuna.delivery.domain.item.ItemCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemCreateRequest {
    private Long id;
    private String category;
    private String name;
    private Integer price;
    private Integer stock;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Item toEntity() {
        return Item.builder()
                .category(ItemCategory.valueOf(category))
                .name(name)
                .price(price)
                .stock(stock)
                .build();
    }
}
