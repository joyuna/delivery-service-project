package com.joyuna.delivery.domain.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {
    private ItemService itemService;
    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponseDto> findById(@PathVariable long id) {
        Item item = itemService.findById(id);
        return ResponseEntity.ok().body(new ItemResponseDto(item));
    }

    @GetMapping
    public ResponseEntity<List<ItemResponseDto>> findAll() {
        List<ItemResponseDto> items = itemService.findAll().stream().map(ItemResponseDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(items);
    }

    @PostMapping
    public ResponseEntity<ItemResponseDto> createItem(@RequestBody ItemCreateRequestDto itemCreateRequestDto) {
        Item item = itemService.save(itemCreateRequestDto);
        return ResponseEntity.ok().body(new ItemResponseDto(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemResponseDto> updateById(@PathVariable long id, @RequestBody ItemUpdateRequestDto itemUpdateRequestDto) {
        Item updateItem = itemService.update(id, itemUpdateRequestDto);
        return ResponseEntity.ok().body(new ItemResponseDto(updateItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        itemService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        itemService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
