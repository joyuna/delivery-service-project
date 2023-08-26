package com.joyuna.delivery.domain.order.dto;

import com.joyuna.delivery.domain.order.Order;
import com.joyuna.delivery.domain.order.OrderItem;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDto {
    private final Long id;
    private final List<OrderItem> orderItems;
//    private final Integer totalPrice;
    private final String receiverName;
    private final String receiverTel;
    private final String receiverAddress;
    private final String orderStatus;
    private final LocalDateTime createDate;
    private final LocalDateTime modifiedDate;

    public OrderResponseDto(Order order) {
        this.id = order.getId();
        this.orderItems = order.getOrderItems();
//        this.totalPrice = order.getTotalPrice;
        this.receiverName = order.getReceiverName();
        this.receiverTel = order.getReceiverTel();
        this.receiverAddress = order.getReceiverAddress();
        this.orderStatus = order.getOrderStatus();
        this.createDate = order.getCreatedDate();
        this.modifiedDate = order.getModifiedDate();
    }
}
