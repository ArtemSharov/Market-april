package ru.gb.artem.marketapril.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.gb.artem.marketapril.models.Product;
import ru.gb.artem.marketapril.utils.Cart;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {
    private final Cart cart;

    @GetMapping("/ping")
    public void ping(@RequestParam Long id) {
        log.info("ping: " + id);
    }

    @GetMapping
    public List<Product> getAllItems(){
       return cart.getAllItems();
    }

    @PostMapping("/addItem")
    public void addItem(@RequestBody Product product){
        cart.addItemsToCart(product);
    }

    @GetMapping("/deleteAllItems")
    public void deleteAllItems(){
        cart.deleteAllItems();
    }


}
