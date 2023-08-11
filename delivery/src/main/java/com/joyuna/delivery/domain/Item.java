package com.joyuna.delivery.domain;

public class Item {
    private final Long itemId;
    private final String itemCategory;
    private final String itemName;
    private final Integer itemPrice;
    private final Integer itemStock;
    private final String itemSaleStatus;

    public Item(Long itemId, String itemCategory, String itemName, Integer itemPrice, Integer itemStock, String itemSaleStatus) {
        this.itemId = itemId;
        this.itemCategory = itemCategory;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
        this.itemSaleStatus = itemSaleStatus;
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
}
