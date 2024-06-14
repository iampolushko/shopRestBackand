package com.example.shoprestbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.shoprestbackend.entities.User;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long amount;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;


}
