package com.example.shoprestbackend.controllers;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.example.shoprestbackend.dto.ProductCreateDto;
import com.example.shoprestbackend.entities.Product;
import com.example.shoprestbackend.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    //TODO What http statuses you real should use?

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductCreateDto dto) {
        return new ResponseEntity<>(productService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<Product>> getById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        productService.delete(id);
        return HttpStatus.OK;
    }
}
