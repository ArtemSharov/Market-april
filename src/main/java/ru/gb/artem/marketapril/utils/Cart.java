package ru.gb.artem.marketapril.utils;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.gb.artem.marketapril.error_handling.ResourceNotFoundException;
import ru.gb.artem.marketapril.models.OrderItem;
import ru.gb.artem.marketapril.models.Product;
import ru.gb.artem.marketapril.services.ProductService;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Data
@RequiredArgsConstructor
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart implements Serializable {
    private List<OrderItem> items;
    private BigDecimal sum;
    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }

    public void clear() {
        items.clear();
        recalculate();
    }

    public void recalculate() {
        sum = BigDecimal.ZERO;
        for (OrderItem oi : items) {
            sum = sum.add(oi.getPrice());
        }
    }

    public BigDecimal getSum(){
        return sum;
    }



    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }


}
