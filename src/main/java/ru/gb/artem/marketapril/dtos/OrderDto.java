package ru.gb.artem.marketapril.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.artem.marketapril.models.Order;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private String orderItems;
    private BigDecimal price;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.orderItems = order.getItems().stream().map(OrderItemDto::new).collect(Collectors.toList()).toString();
        this.price = order.getPrice();
    }
}
