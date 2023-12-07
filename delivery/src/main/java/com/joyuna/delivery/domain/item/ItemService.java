package com.joyuna.delivery.domain.item;

import com.joyuna.delivery.domain.item.dto.*;
import com.joyuna.delivery.domain.order.OrderItem;
import com.joyuna.delivery.domain.order.dto.OrderItemAddRequest;
import com.joyuna.delivery.domain.order.dto.TotalPriceRequest;
import com.joyuna.delivery.domain.order.dto.ItemPriceResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public ItemCreateResponse createItem(ItemCreateRequest request) {
        Item item = itemRepository.save(request.toEntity());
        return new ItemCreateResponse(item);
    }

    @Transactional(readOnly = true)
    public ItemInfoResponse getOne(long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("조회 결과 없음 : " + id));
        return new ItemInfoResponse(item);
    }

    @Transactional(readOnly = true)
    public List<ItemInfoResponse> getAll() {
        return itemRepository.findAll().stream().map(ItemInfoResponse::new).collect(Collectors.toList());
    }

    @Transactional
    public ItemUpdateResponse updateItem(long id, ItemUpdateRequest request) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("조회 결과 없음 : " + id));
        item.update(ItemCategory.valueOf(request.getCategory()), request.getName(), request.getPrice(), request.getStock(), request.getSaleStatus());
        return new ItemUpdateResponse(item);
    }

    @Transactional
    public void deleteOne(long id) {
        itemRepository.deleteById(id);
    }

    @Transactional
    public void deleteAll() {
        itemRepository.deleteAll();
    }

    @Transactional
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

    @Transactional
    public List<ItemPriceResponse> getPriceOrderItem(TotalPriceRequest totalPriceRequest) {
        List<Long> orderItemIdList = new ArrayList<>();

        for(OrderItemAddRequest orderItemAddRequest : totalPriceRequest.getOrderItemList()) {
            orderItemIdList.add(orderItemAddRequest.getItemId());
        }

        List<Item> itemList = itemRepository.findByIdIn(orderItemIdList);
        List<ItemPriceResponse> ItemPriceListResponse = new ArrayList<>();

        for(Item item : itemList) {
            ItemPriceListResponse.add(new ItemPriceResponse(item.getId(), item.getPrice()));
        }
        return ItemPriceListResponse;
    }
}
