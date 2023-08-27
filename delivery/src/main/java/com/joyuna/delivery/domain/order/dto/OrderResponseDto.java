package com.joyuna.delivery.domain.order.dto;

import com.joyuna.delivery.domain.order.Order;
import com.joyuna.delivery.domain.order.OrderItem;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OrderResponseDto {
    private final Long orderId;
    private final List<OrderItem> orderItemList;
    private final Integer totalPrice;
    private final String receiverName;
    private final String receiverTel;
    private final String receiverAddress;
    private final String orderStatus;
    private final LocalDateTime createDate;
    private final LocalDateTime modifiedDate;

    public OrderResponseDto(Order order) {
        this.orderId = order.getId();
        this.orderItemList = order.getOrderItemList();

        int totalOrderPrice = 0;
        for(OrderItem orderItem : orderItemList) {
            totalOrderPrice += orderItem.getOrderPrice();
        }

        this.totalPrice = totalOrderPrice;
        this.receiverName = order.getReceiverName();
        this.receiverTel = order.getReceiverTel();
        this.receiverAddress = order.getReceiverAddress();
        this.orderStatus = order.getOrderStatus();
        this.createDate = order.getCreatedDate();
        this.modifiedDate = order.getModifiedDate();
    }
}
