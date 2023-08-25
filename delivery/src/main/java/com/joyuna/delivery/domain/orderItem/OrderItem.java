package com.joyuna.delivery.domain.orderItem;

import com.joyuna.delivery.domain.item.Item;
import com.joyuna.delivery.domain.order.Order;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id", updatable = false)
    private Long id;

    @Column(name = "count", nullable = false)
    private Integer count;

    @Column(name = "order_price", nullable = false)
    private Integer orderPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Builder
    public OrderItem(Integer count, Integer orderPrice, Item item, Order order) {
        this.count = count;
        this.orderPrice = orderPrice;
        this.item = item;
        this.order = order;
    }
}
