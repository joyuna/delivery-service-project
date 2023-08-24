package com.joyuna.delivery.domain.item;

import com.joyuna.delivery.domain.item.dto.ItemCreateRequestDto;
import com.joyuna.delivery.domain.item.dto.ItemResponseDto;
import com.joyuna.delivery.domain.item.dto.ItemUpdateRequestDto;
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
        return ResponseEntity.ok().body(itemService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ItemResponseDto>> findAll() {
        List<ItemResponseDto> items = itemService.findAll();
        return ResponseEntity.ok().body(items);
    }

    @PostMapping
    public ResponseEntity<ItemResponseDto> createItem(@RequestBody ItemCreateRequestDto itemCreateRequestDto) {
        return ResponseEntity.ok().body(itemService.save(itemCreateRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemResponseDto> updateById(@PathVariable long id, @RequestBody ItemUpdateRequestDto itemUpdateRequestDto) {
        return ResponseEntity.ok().body(itemService.update(id, itemUpdateRequestDto));
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
