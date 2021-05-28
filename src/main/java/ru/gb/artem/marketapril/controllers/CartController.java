package ru.gb.artem.marketapril.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.gb.artem.marketapril.dtos.CartDto;
import ru.gb.artem.marketapril.services.CartService;
import ru.gb.artem.marketapril.utils.Cart;


@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {
    private final CartService cartService;


    @GetMapping("/add/{productId}")
    public void addToCart(@PathVariable(name = "productId") Long id) {
        cartService.addToCart(id);
    }

    @GetMapping("/clear")
    public void clearCart() {
        cartService.clear();
    }

    @GetMapping
    public CartDto getCart() {
        return new CartDto(cartService.getCart());
    }
}
