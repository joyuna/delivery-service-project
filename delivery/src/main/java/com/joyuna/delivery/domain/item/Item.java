package com.joyuna.delivery.domain.item;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "category", nullable = false)
    private String category;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name= "stock", nullable = false)
    private Integer stock;
    @Column(name = "status", nullable = false)
    private String saleStatus;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "modified_date", nullable = false)
    private LocalDateTime modifiedDate;

    @Builder
    public Item(Long id, String category, String name, Integer price, Integer stock, String saleStatus, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.saleStatus = saleStatus;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
