package ru.gb.artem.marketapril.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.gb.artem.marketapril.dtos.CartDto;
import ru.gb.artem.marketapril.dtos.ProductDto;
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
    public List<ProductDto> getAllItems(){
       CartDto outCart = new CartDto(cart);
        return outCart.getAllItems();
    }

    @GetMapping("/addItem")
    public void addItem(@RequestParam Long id){
        cart.addItemsToCart(id);
    }

    @GetMapping("/deleteAllItems")
    public void deleteAllItems(){
        cart.deleteAllItems();
    }


}
