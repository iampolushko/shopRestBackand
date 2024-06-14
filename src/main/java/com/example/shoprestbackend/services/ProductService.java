package com.example.shoprestbackend.services;

import com.example.shoprestbackend.dto.ProductCreateDto;
import com.example.shoprestbackend.entities.Product;
import com.example.shoprestbackend.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product create(ProductCreateDto dto) {
        Product product = Product.builder()
                .name(dto.getName())
                .build();
        return productRepository.save(product);
    }

    //TODO Может лучше в update передать dto, а не user?
    public List<Product> readAll() {
        return productRepository.findAll();
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }
}
