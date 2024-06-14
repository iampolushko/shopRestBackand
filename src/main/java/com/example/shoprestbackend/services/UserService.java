package com.example.shoprestbackend.services;

import com.example.shoprestbackend.dto.UserCreateDto;
import com.example.shoprestbackend.entities.User;
import com.example.shoprestbackend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(UserCreateDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .build();
        return userRepository.save(user);
    }

    public List<User> readAll() {
        return userRepository.findAll();
    }

    //TODO Может лучше в update передать dto, а не user?
    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

}
