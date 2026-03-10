package com.ashcode.store.controllers;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashcode.store.dtos.UserDto;
import com.ashcode.store.mappers.UserMapper;
import com.ashcode.store.repositories.UserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping(path = "/api/users")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

    UserRepository userRepository;
    UserMapper userMapper;

    @GetMapping
    public Iterable<UserDto> fetchAllUsers(
            @RequestParam(name = "sort") String sort) {

        return userRepository.findAll(Sort.by(sort))
                .stream()
                .map(user -> userMapper.toDto(user))
                .toList();

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> fetchUser(@PathVariable(name = "id") Long id) {

        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        var userDto = userMapper.toDto(user);
        return ResponseEntity.ok(userDto);
    }

}
