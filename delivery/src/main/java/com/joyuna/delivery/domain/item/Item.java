package com.joyuna.delivery.domain.item;

import com.joyuna.delivery.domain.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id",updatable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemCategory category;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ItemSaleStatus saleStatus;

    @Builder
    public Item(ItemCategory category, String name, Integer price, Integer stock) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.saleStatus = ItemSaleStatus.NORMAL;
    }

    public Item(Long id) {
        this.id = id;
    }

    public void update(ItemCategory category, String name, Integer price, Integer stock, ItemSaleStatus saleStatus) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.saleStatus = saleStatus;
    }
}
