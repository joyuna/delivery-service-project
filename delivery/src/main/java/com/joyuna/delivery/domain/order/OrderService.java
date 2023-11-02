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
//    public void getItemsTotalPrice(OrderItemAddRequest)


    public OrderCreateResponse createOrder(OrderCreateRequest orderCreateRequest) {
        // # 1. 사용자가 주문한 음식(상품) 리스트의 금액을 산출한다.
        // 1-1. orderCreateRequest엔 상품 가격이 없다. orderItemAddRequest에도 주문한 상품의 아이디만 있을 뿐이다.
        // 1-2. 상품의 아이디를 통해 주문한 상품의 가격을 가져와야한다.
        //   현재 이곳에서 진행하기엔 여러번 찔러야 하니 request에서 주문 목록을 그대로 들고 item에 가져가서 값을 산출해오는게 좋을 것 같다.
        // 1-3. 상품의 가격을 갯수에 맞게 곱해서 총 금액을 구해야한다.

        TotalPriceRequest totalPriceRequest = new TotalPriceRequest(orderCreateRequest.getOrderItemList());

        List<ItemPriceResponse> ItemPriceListResponse =  itemService.getPriceOrderItem(totalPriceRequest);
        Order order = orderCreateRequest.toEntity(ItemPriceListResponse);

        orderRepository.save(order);
        orderItemRepository.saveAll(order.getOrderItemList());

        return new OrderCreateResponse(order);
    }
}
