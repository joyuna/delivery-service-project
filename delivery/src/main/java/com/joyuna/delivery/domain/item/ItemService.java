package com.joyuna.delivery.domain.item;

import com.joyuna.delivery.domain.item.dto.ItemCreateRequestDto;
import com.joyuna.delivery.domain.item.dto.ItemResponseDto;
import com.joyuna.delivery.domain.item.dto.ItemUpdateRequestDto;
import com.joyuna.delivery.domain.order.OrderItem;
import com.joyuna.delivery.domain.order.dto.OrderItemRequestDto;
import com.joyuna.delivery.domain.order.dto.PriceRequestDto;
import com.joyuna.delivery.domain.order.dto.PriceResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private ItemRepository itemRepository;
    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemResponseDto findById(long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("조회 결과 없음 : " + id));
        return new ItemResponseDto(item);
    }

    public List<ItemResponseDto> findAll() {
        return itemRepository.findAll().stream().map(ItemResponseDto::new).collect(Collectors.toList());
    }

    public ItemResponseDto save(ItemCreateRequestDto itemCreateRequestDto) {
        Item item = itemRepository.save(itemCreateRequestDto.toEntity());
        return new ItemResponseDto(item);
    }

    @Transactional
    public ItemResponseDto update(long id, ItemUpdateRequestDto itemUpdateRequestDto) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("조회 결과 없음 : " + id));
        item.update(itemUpdateRequestDto.getCategory(), itemUpdateRequestDto.getName(), itemUpdateRequestDto.getPrice(), itemUpdateRequestDto.getStock(), itemUpdateRequestDto.getSaleStatus());
        return new ItemResponseDto(item);
    }

    public void deleteById(long id) {
        itemRepository.deleteById(id);
    }

    public void deleteAll() {
        itemRepository.deleteAll();
    }

    public int getTotalPrice(List<OrderItem> orderItemList) {
        List<Long> itemIdList = new ArrayList<>();
        for(OrderItem orderItem : orderItemList) {
            Long id = orderItem.getItem().getId();
            itemIdList.add(id);
        }
        List<Item> itemList = itemRepository.findByIdIn(itemIdList);
        int totalPrice = 0;
        for(Item item : itemList) {
            for(OrderItem orderItem : orderItemList) {
                if(orderItem.getItem().getId().equals(item.getId())) {
                    totalPrice += orderItem.getCount() * item.getPrice();
                }
            }
        }
        return totalPrice;
    }

    public List<PriceResponseDto> getPriceOrderItem(PriceRequestDto priceRequestDto) {
        List<Long> orderItemIdList = new ArrayList<>();
        for(OrderItemRequestDto orderItemRequestDto : priceRequestDto.getOrderItemListDto()) {
            orderItemIdList.add(orderItemRequestDto.getItemId());
        }
        List<Item> itemList = itemRepository.findByIdIn(orderItemIdList);
        List<PriceResponseDto> priceListResponseDto = new ArrayList<>();
        for(Item item : itemList) {
            priceListResponseDto.add(new PriceResponseDto(item.getId(), item.getPrice()));
        }
        return priceListResponseDto;
    }
}
