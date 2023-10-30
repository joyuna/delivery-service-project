package com.joyuna.delivery.domain.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joyuna.delivery.domain.common.BaseTimeEntity;
import com.joyuna.delivery.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id",updatable = false)
    private Long id;

    @Column(nullable = false)
    private String receiverTel;

    @Column(nullable = false)
    private String receiverAddress;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus orderStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Order(Member member, String receiverTel, String receiverAddress, List<OrderItem> orderItemList) {
        this.member = member;
        this.receiverTel = receiverTel;
        this.receiverAddress = receiverAddress;
        this.orderStatus = OrderStatus.ORDERED;
        this.orderItemList = orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
