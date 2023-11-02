package com.joyuna.delivery.domain.item.dto;

import com.joyuna.delivery.domain.item.Item;
import com.joyuna.delivery.domain.item.ItemCategory;
import com.joyuna.delivery.domain.item.ItemSaleStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class ItemInfoResponse {
    private Long id;
    private ItemCategory category;
    private String name;
    private Integer price;
    private Integer stock;
    private ItemSaleStatus saleStatus;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public ItemInfoResponse(Item item) {
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
