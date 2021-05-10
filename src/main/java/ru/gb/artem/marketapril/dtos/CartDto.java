package ru.gb.artem.marketapril.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.artem.marketapril.models.Product;
import ru.gb.artem.marketapril.utils.Cart;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CartDto {
    List<ProductDto> itemsDto = new ArrayList<>();

    public CartDto(Cart cart){
        for (Product items : cart.getAllItems()) {
            ProductDto productDto = new ProductDto(items);
           this.itemsDto.add(productDto);
        }
    }
    public List<ProductDto> getAllItems(){
        return itemsDto;
    }
}
