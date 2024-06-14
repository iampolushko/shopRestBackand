package com.example.shoprestbackend.controllers;

import com.example.shoprestbackend.dto.UserCreateDto;
import com.example.shoprestbackend.entities.Product;
import com.example.shoprestbackend.entities.User;
import com.example.shoprestbackend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserCreateDto dto) {
        return new ResponseEntity<>(userService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<User>> getById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        userService.delete(id);
        return HttpStatus.OK;
    }

}
