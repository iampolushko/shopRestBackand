package com.example.shoprestbackend.controllers;

import com.example.shoprestbackend.dto.OrderCreateDto;
import com.example.shoprestbackend.entities.Order;
import com.example.shoprestbackend.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//TODO It doesn't work
@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderCreateDto dto){
        return new ResponseEntity<>(orderService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return new ResponseEntity<>(orderService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getById(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.getById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Order> update(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.update(order), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        orderService.delete(id);
        return HttpStatus.OK;
    }
}
