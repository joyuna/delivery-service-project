package com.joyuna.delivery.domain.order.dto;

import com.joyuna.delivery.domain.order.Order;
import com.joyuna.delivery.domain.order.OrderItem;
import com.joyuna.delivery.domain.order.OrderStatus;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OrderCreateResponse {
    private Long orderId;
    private List<OrderItem> orderItemList;
    private Integer totalPrice;
    private String receiverTel;
    private String receiverAddress;
    private OrderStatus orderStatus;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public OrderCreateResponse(Order order) {
        this.orderId = order.getId();
        this.orderItemList = order.getOrderItemList();

        int totalOrderPrice = 0;
        for(OrderItem orderItem : orderItemList) {
            totalOrderPrice += orderItem.getOrderPrice();
        }

        this.totalPrice = totalOrderPrice;
        this.receiverTel = order.getReceiverTel();
        this.receiverAddress = order.getReceiverAddress();
        this.orderStatus = order.getOrderStatus();
        this.createDate = order.getCreatedDate();
        this.modifiedDate = order.getModifiedDate();
    }
}
