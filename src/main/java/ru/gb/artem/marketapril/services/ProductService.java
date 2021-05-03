package ru.gb.artem.marketapril.services;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.artem.marketapril.models.Product;
import ru.gb.artem.marketapril.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

}
