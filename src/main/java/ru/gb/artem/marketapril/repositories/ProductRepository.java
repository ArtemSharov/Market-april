package ru.gb.artem.marketapril.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.artem.marketapril.models.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllBy(Pageable pageable);
}