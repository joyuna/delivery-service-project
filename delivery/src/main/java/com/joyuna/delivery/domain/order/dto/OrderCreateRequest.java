package com.joyuna.delivery.domain.order.dto;

import com.joyuna.delivery.domain.member.Member;
import com.joyuna.delivery.domain.order.Order;
import com.joyuna.delivery.domain.order.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequest {
    private Long memberId;
    private List<OrderItemAddRequest> orderItemList;
    private String receiverTel;
    private String receiverAddress;

    public Order toEntity(List<ItemPriceResponse> itemPriceListResponse) {
        List<OrderItem> orderItemList = new ArrayList<>();

        Order order = Order.builder()
                .member(new Member(memberId))
                .receiverTel(receiverTel)
                .receiverAddress(receiverAddress)
                .build();

        for(OrderItemAddRequest orderItemAddRequest : this.orderItemList) {
            for(ItemPriceResponse itemPriceResponse : itemPriceListResponse) {
                if(orderItemAddRequest.getItemId().equals(itemPriceResponse.getItemId())) {
                    OrderItem orderItem = orderItemAddRequest.toEntity(order, itemPriceResponse.getPrice());
                    orderItemList.add(orderItem);
                }
            }
        }
        order.setOrderItemList(orderItemList);

        return order;
    }
}
