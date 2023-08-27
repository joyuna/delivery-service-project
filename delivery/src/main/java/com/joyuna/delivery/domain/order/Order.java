package com.joyuna.delivery.domain.order;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "orders")
@DynamicInsert
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", updatable = false)
    private Long id;

    @Column(name = "receiver_name", nullable = false)
    private String receiverName;

    @Column(name ="receiver_tel", nullable = false)
    private String receiverTel;

    @Column(name ="receiver_address", nullable = false)
    private String receiverAddress;

    @Column(name = "status", nullable = false)
    @ColumnDefault("주문 요청")
    private String orderStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList = new ArrayList<>();

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "modified_date", nullable = false)
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Builder
    public Order(String receiverName, String receiverTel, String receiverAddress, List<OrderItem> orderItemList) {
        this.receiverName = receiverName;
        this.receiverTel = receiverTel;
        this.receiverAddress = receiverAddress;
        this.orderStatus = "주문 요청";
        this.orderItemList = orderItemList;
    }
}
