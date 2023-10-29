package com.joyuna.delivery.domain.order;

import com.joyuna.delivery.domain.item.ItemService;
import com.joyuna.delivery.domain.order.dto.OrderRequestDto;
import com.joyuna.delivery.domain.order.dto.OrderResponseDto;
import com.joyuna.delivery.domain.order.dto.PriceRequestDto;
import com.joyuna.delivery.domain.order.dto.PriceResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private ItemService itemService;
    private OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository, ItemService itemService, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.itemService = itemService;
        this.orderItemRepository = orderItemRepository;
    }

    public OrderResponseDto save(OrderRequestDto orderRequestDto) {
        PriceRequestDto priceRequestDto = new PriceRequestDto(orderRequestDto.getOrderItemListDto());
        List<PriceResponseDto> priceListResponseDto = itemService.getPriceOrderItem(priceRequestDto);
        Order newOrder = orderRequestDto.toEntity(priceListResponseDto);
        
        orderRepository.save(newOrder);
        orderItemRepository.saveAll(newOrder.getOrderItemList());

        return new OrderResponseDto(newOrder);
    }
}
