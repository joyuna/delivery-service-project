package com.joyuna.delivery.domain.order.dto;

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
public class OrderRequestDto {
    private List<OrderItemRequestDto> orderItemListDto;
    private String receiverName;
    private String receiverTel;
    private String receiverAddress;

    public Order toEntity(List<PriceResponseDto> priceListResponseDto) {
        List<OrderItem> orderItemList = new ArrayList<>();
        Order order = Order.builder()
                .receiverName(receiverName)
                .receiverTel(receiverTel)
                .receiverAddress(receiverAddress)
                .build();
        for(OrderItemRequestDto orderItemDto : orderItemListDto) {
            for(PriceResponseDto priceResponseDto : priceListResponseDto) {
                if(orderItemDto.getItemId().equals(priceResponseDto.getItemId())) {
                    OrderItem orderItem = orderItemDto.toEntity(order, priceResponseDto.getPrice());
                    orderItemList.add(orderItem);
                }
            }
        }
        order.setOrderItemList(orderItemList);
        return order;
    }
}
