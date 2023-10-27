package com.joyuna.delivery.domain.item;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id",updatable = false)
    private Long id;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    @Column(name = "status", nullable = false)
    private String saleStatus;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Builder
    public Item(String category, String name, Integer price, Integer stock, String saleStatus) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.saleStatus = saleStatus;
    }

    public Item(Long id) {
        this.id = id;
    }

    public void update(String category, String name, Integer price, Integer stock, String saleStatus) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.saleStatus = saleStatus;
    }
}
