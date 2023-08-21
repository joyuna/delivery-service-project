package com.joyuna.delivery.domain.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Item  item = itemService.findById(id);
        return ResponseEntity.ok().body(new ItemResponseDto(item));
    }
}
