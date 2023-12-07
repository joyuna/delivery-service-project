package com.joyuna.delivery.domain.order;

import com.joyuna.delivery.domain.item.ItemService;
import com.joyuna.delivery.domain.order.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemService itemService;
    private final OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository, ItemService itemService, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.itemService = itemService;
        this.orderItemRepository = orderItemRepository;
    }

    public OrderCreateResponse createOrder(OrderCreateRequest orderCreateRequest) {

        TotalPriceRequest totalPriceRequest = new TotalPriceRequest(orderCreateRequest.getOrderItemList());

        List<ItemPriceResponse> ItemPriceListResponse =  itemService.getPriceOrderItem(totalPriceRequest);
        Order order = orderCreateRequest.toEntity(ItemPriceListResponse);

        orderRepository.save(order);
        orderItemRepository.saveAll(order.getOrderItemList());

        return new OrderCreateResponse(order);
    }
}
