package com.example.shoprestbackend.services;

import com.example.shoprestbackend.dto.OrderCreateDto;
import com.example.shoprestbackend.entities.Order;
import com.example.shoprestbackend.repositories.OrderRepository;
import com.example.shoprestbackend.repositories.ProductRepository;
import com.example.shoprestbackend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    private ProductService productService;
    private UserService userService;

    public Order create(OrderCreateDto dto) {
        Order order = Order.builder()
                .amount(dto.getAmount())
                .user(userService.getById(dto.getProductId()).get())
                .product(productService.getById(dto.getProductId()).get())
                .build();
        return orderRepository.save(order);
    }

    public List<Order> readAll() {
        return orderRepository.findAll();
    }

    //TODO Может лучше в update передать dto, а не user?
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }

}
