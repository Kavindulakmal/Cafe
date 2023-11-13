package com.cart.demo.controller;

import com.cart.demo.model.CartItem;
import com.cart.demo.repository.CartItemRepository;
import com.cart.demo.service.CartItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cart")
@Validated
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping
    public List<CartItem> getAllItems(){
        return cartItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getItemById(@PathVariable Long id){
        return cartItemService.getItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CartItem> addItem(@Valid @RequestBody CartItem cartItem){
        CartItem savedItem =cartItemService.saveItem(cartItem);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItem> updateItem(@PathVariable Long id,@Valid @RequestBody CartItem cartItem){
        if(!cartItemService.getItemById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        cartItem.setId(id);
        CartItem updateItem = cartItemService.saveItem(cartItem);
        return ResponseEntity.ok(updateItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id){
        if (!cartItemService.getItemById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        cartItemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
