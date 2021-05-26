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
    private String description;
    private BigDecimal price;
    private String contactPhone;
    private String deliveryAddress;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.description = order.getItems().stream().map(o -> o.getProduct().getTitle() + " x" + o.getQuantity()).collect(Collectors.joining(", "));
        this.price = order.getPrice();
    }
}
