package ru.gb.artem.marketapril.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ru.gb.artem.marketapril.entities.ProductEntity;
import ru.gb.artem.marketapril.repositories.ProductRepositorySoap;
import ru.gb.artem.marketapril.soap.products.Product;
import ru.gb.artem.marketapril.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductSoapService {
    private final ProductRepositorySoap productRepositorySoap;

    public static final Function<ProductEntity, ru.gb.artem.marketapril.soap.products.Product> functionEntityToSoap = pe -> {
        Product p = new Product();
        p.setId(pe.getId());
        p.setTitle(pe.getTitle());
        p.setPrice(pe.getPrice());
        p.setCategory(pe.getCategory());
        return p;
    };

    public List<Product> getAllProducts() {
        return productRepositorySoap.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }

}
