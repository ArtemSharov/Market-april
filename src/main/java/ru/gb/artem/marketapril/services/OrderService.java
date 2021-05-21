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

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final Cart cart;


    @Transactional
    public Order createOrderForCurrentUser(User user, String phone, String address){
        Order order = new Order();
        order.setUser(user);
        order.setItems(cart.getItems());
        order.setPrice(cart.getSum());
        order.setContactPhone(phone);
        order.setDeliveryAddress(address);

        for (OrderItem oi : cart.getItems()) {
            oi.setOrder(order);
        }
       orderRepository.save(order);
       cart.clear();
       return order;
    }

    public List<Order> findAllByUser(User user) {
        return orderRepository.findAllByUser(user);
    }

}