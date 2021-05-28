package ru.gb.artem.marketapril.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.artem.marketapril.error_handling.ResourceNotFoundException;
import ru.gb.artem.marketapril.models.OrderItem;
import ru.gb.artem.marketapril.models.Product;
import ru.gb.artem.marketapril.utils.Cart;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final Cart cart;
    private final ProductService productService;
    BigDecimal sum;


    public void addToCart(Long id) {
        for (OrderItem orderItem : cart.getItems()) {
            if (orderItem.getProduct().getId().equals(id)) {
                orderItem.incrementQuantity();
                recalculate();
                return;
            }
        }

        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product doesn't exists id: " + id + " (add to cart)"));
        cart.getItems().add(new OrderItem(product));
        recalculate();
    }

    public void clear() {
        cart.getItems().clear();
        recalculate();
    }

    private void recalculate() {
        sum = BigDecimal.ZERO;
        for (OrderItem oi : cart.getItems()) {
            sum = sum.add(oi.getPrice());
        }
        cart.setSum(sum);
    }

    public BigDecimal getSum(){
        return cart.getSum();
    }

    public Cart getCart(){
        return cart;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(cart.getItems());
    }
}
