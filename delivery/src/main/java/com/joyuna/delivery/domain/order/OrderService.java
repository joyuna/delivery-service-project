package com.joyuna.delivery.domain.order;

import com.joyuna.delivery.domain.item.ItemService;
import com.joyuna.delivery.domain.order.dto.OrderRequestDto;
import com.joyuna.delivery.domain.order.dto.PriceRequestDto;
import com.joyuna.delivery.domain.order.dto.PriceResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderService {
    private OrderRepository orderRepository;
    private ItemService itemService;

    public OrderService(OrderRepository orderRepository, ItemService itemService) {
        this.orderRepository = orderRepository;
        this.itemService = itemService;
    }

    public void save(OrderRequestDto orderRequestDto) {
        log.info("save order orderRequestDto : {}", orderRequestDto.toString());
        PriceRequestDto priceRequestDto = new PriceRequestDto(orderRequestDto.getOrderItemListDto());
        log.info("save order priceRequestDto : {}", priceRequestDto);
        List<PriceResponseDto> priceListResponseDto =  itemService.getPriceOrderItem(priceRequestDto);
        Order order = orderRepository.save(orderRequestDto.toEntity(priceListResponseDto));
    }
}
