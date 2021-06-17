package ru.gb.artem.marketapril.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.artem.marketapril.entities.ProductEntity;
import ru.gb.artem.marketapril.models.Product;

import java.util.Optional;


@Repository
public interface ProductRepositorySoap extends JpaRepository<ProductEntity, Long> {

}