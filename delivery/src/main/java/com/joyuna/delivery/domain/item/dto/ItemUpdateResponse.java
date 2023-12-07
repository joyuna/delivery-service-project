package com.joyuna.delivery.domain.item.dto;

import com.joyuna.delivery.domain.item.Item;
import com.joyuna.delivery.domain.item.ItemCategory;
import com.joyuna.delivery.domain.item.ItemSaleStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class ItemUpdateResponse {
    private final Long id;
    private final ItemCategory category;
    private final String name;
    private final Integer price;
    private final Integer stock;
    private final ItemSaleStatus saleStatus;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public ItemUpdateResponse(Item item) {
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
