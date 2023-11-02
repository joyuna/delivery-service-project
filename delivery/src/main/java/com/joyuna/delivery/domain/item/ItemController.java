package com.joyuna.delivery.domain.item;

import com.joyuna.delivery.domain.item.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemCreateResponse> createItem(@RequestBody ItemCreateRequest request) {
        return ResponseEntity.ok().body(itemService.createItem(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemInfoResponse> getOne(@PathVariable long id) {
        return ResponseEntity.ok().body(itemService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<ItemInfoResponse>> getAll() {
        List<ItemInfoResponse> items = itemService.getAll();
        return ResponseEntity.ok().body(items);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemUpdateResponse> updateItem(@PathVariable long id, @RequestBody ItemUpdateRequest request) {
        return ResponseEntity.ok().body(itemService.updateItem(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable long id) {
        itemService.deleteOne(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        itemService.deleteAll();
        return ResponseEntity.ok().build();
    }
}