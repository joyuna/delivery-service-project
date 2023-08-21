package com.joyuna.delivery.domain.item;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ItemResponseDto {
    private final Long id;
    private final String category;
    private final String name;
    private final Integer price;
    private final Integer stock;
    private final String saleStatus;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public ItemResponseDto(Item item) {
        this.id = item.getId();
        this.category = item.getCategory();
        this.name = item.getName();
        this.price = item.getPrice();
        this.stock = item.getStock();
        this.saleStatus = item.getSaleStatus();
        this.createdDate = item.getCreatedDate();
        this.modifiedDate = item.getModifiedDate();
    }
}
