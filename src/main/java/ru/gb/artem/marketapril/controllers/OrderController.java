package ru.gb.artem.marketapril.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.artem.marketapril.dtos.OrderDto;
import ru.gb.artem.marketapril.models.User;
import ru.gb.artem.marketapril.services.OrderService;
import ru.gb.artem.marketapril.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;

    @PostMapping
        public void createNewOrder(@RequestBody @Validated OrderDto orderDto, Principal principal) {
        User user = userService.findByUsername(principal.getName()).get();
        orderService.createOrderForCurrentUser(user, orderDto.getContactPhone(), orderDto.getDeliveryAddress());
    }

    @GetMapping
    @Transactional
    public List<OrderDto> getAllOrdersForCurrentUser(Principal principal) {
        User user = userService.findByUsername(principal.getName()).get();
        return orderService.findAllByUser(user).stream().map(OrderDto::new).collect(Collectors.toList());
    }

}
