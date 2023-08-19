package com.joyuna.delivery.domain;

import java.time.LocalDateTime;

public class Item {
    private final Long itemId;
    private final String itemCategory;
    private final String itemName;
    private final Integer itemPrice;
    private final Integer itemStock;
    private final String itemSaleStatus;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public Item(Long itemId, String itemCategory, String itemName, Integer itemPrice, Integer itemStock, String itemSaleStatus, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.itemId = itemId;
        this.itemCategory = itemCategory;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
        this.itemSaleStatus = itemSaleStatus;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Long getItemId() {
        return itemId;
    }
    public String getItemCategory() {
        return itemCategory;
    }
    public String getItemName() {
        return itemName;
    }
    public Integer getItemPrice() {
        return itemPrice;
    }
    public Integer getItemStock() {
        return itemStock;
    }
    public String getItemSaleStatus() {
        return itemSaleStatus;
    }
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }
}
