package ru.gb.artem.marketapril.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.artem.marketapril.error_handling.ResourceNotFoundException;
import ru.gb.artem.marketapril.models.Product;
import ru.gb.artem.marketapril.repositories.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Cart {
    private List<Product> items;
    private final ProductRepository productRepository;

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }

    public List<Product> getAllItems(){
        return items;
    }

    public void addItemsToCart(Long id){
        if(productRepository.findById(id).isPresent()){
            items.add(productRepository.findById(id).get());
        } else throw new ResourceNotFoundException("Product doesn't exists id: " + id + " (for add)");
    }

    public void deleteAllItems(){
        items.clear();
    }




}
