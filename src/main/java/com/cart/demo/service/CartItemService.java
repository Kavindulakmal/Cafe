package com.cart.demo.service;

import com.cart.demo.model.CartItem;
import com.cart.demo.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getAllItems(){
        return cartItemRepository.findAll();
    }

    public Optional<CartItem> getItemById(Long id){
        return cartItemRepository.findById(id);
    }

    public CartItem saveItem(CartItem cartItem){
        return cartItemRepository.save(cartItem);
    }

    public void deleteItem(Long id){
        cartItemRepository.deleteById(id);
    }
}
