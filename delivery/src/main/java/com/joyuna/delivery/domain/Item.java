package com.joyuna.delivery.domain;

public class Item {
    private final Long itemId;
    private final String itemCategory;
    private final String itemName;
    private final Integer itemPrice;

    public Item(Long itemId, String itemCategory, String itemName, Integer itemPrice) {
        this.itemId = itemId;
        this.itemCategory = itemCategory;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
}
