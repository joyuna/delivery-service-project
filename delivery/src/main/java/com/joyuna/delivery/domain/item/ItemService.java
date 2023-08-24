package com.joyuna.delivery.domain.item;

import com.joyuna.delivery.domain.item.dto.ItemCreateRequestDto;
import com.joyuna.delivery.domain.item.dto.ItemResponseDto;
import com.joyuna.delivery.domain.item.dto.ItemUpdateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
