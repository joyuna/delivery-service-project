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
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;
    @Column(name = "modified_date", nullable = false)
    @LastModifiedDate
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

    public void update(String category, String name, Integer price, Integer stock, String saleStatus) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.saleStatus = saleStatus;
    }
}
