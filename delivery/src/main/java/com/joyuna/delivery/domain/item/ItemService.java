package com.joyuna.delivery.domain.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {
    private ItemRepository itemRepository;
    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item findById(long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("조회 결과 없음 : " + id));
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item save(ItemRequestDto itemRequestDto) {
        return itemRepository.save(itemRequestDto.toEntity());
    }

    @Transactional
    public Item update(long id, ItemUpdateRequestDto itemUpdateRequestDto) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("조회 결과 없음 : " + id));
        item.update(itemUpdateRequestDto.getCategory(), itemUpdateRequestDto.getName(), itemUpdateRequestDto.getPrice(), itemUpdateRequestDto.getStock(), itemUpdateRequestDto.getSaleStatus());
        return item;
    }
}
