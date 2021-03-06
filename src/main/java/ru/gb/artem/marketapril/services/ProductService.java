package ru.gb.artem.marketapril.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.artem.marketapril.dtos.ProductDto;
import ru.gb.artem.marketapril.error_handling.ResourceNotFoundException;
import ru.gb.artem.marketapril.models.Category;
import ru.gb.artem.marketapril.models.Product;
import ru.gb.artem.marketapril.repositories.ProductRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public Page<Product> findPage(int page, int pageSize) {
        return productRepository.findAllBy(PageRequest.of(page, pageSize));
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public ProductDto createNewProduct(ProductDto productDto) {
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        Category category = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Category doesn't exists product.categoryTitle = " + productDto.getCategoryTitle() + " (Product creation)"));
        product.setCategory(category);
        productRepository.save(product);
        return new ProductDto(product);
    }

    @Transactional
    public ProductDto updateProduct(ProductDto productDto) {
        Product product = findById(productDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Product doesn't exists id: " + productDto.getId() + " (for update)"));
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        Category category = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Category doesn't exists product.categoryTitle = " + productDto.getCategoryTitle() + " (Product creation)"));
        product.setCategory(category);
        return new ProductDto(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
