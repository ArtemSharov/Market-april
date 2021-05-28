package ru.gb.artem.marketapril.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.artem.marketapril.dtos.OrderDto;
import ru.gb.artem.marketapril.models.Order;
import ru.gb.artem.marketapril.models.OrderItem;
import ru.gb.artem.marketapril.models.User;
import ru.gb.artem.marketapril.repositories.OrderRepository;
import ru.gb.artem.marketapril.utils.Cart;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cart;

    public List<Order> findAllByUser(User user) {
        return orderRepository.findAllByUser(user);
    }

    public Order createOrderForCurrentUser(User user) {
        Order order = new Order();
        order.setUser(user);
        order.setPrice(cart.getSum());
        // todo распутать этот кусок
        order.setItems(cart.getItems());
        for (OrderItem oi : cart.getItems()) {
            oi.setOrder(order);
        }
        order = orderRepository.save(order);
        cart.clear();
        return order;
    }
}

