package com.ashcode.store.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashcode.store.dtos.products.ProductDto;
import com.ashcode.store.entities.Product;
import com.ashcode.store.mappers.ProductMapper;
import com.ashcode.store.repositories.ProductRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping(path = "/api/products")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

    ProductRepository productRepository;
    ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> fetchAllProducts(
            @RequestParam(name = "categoryId", required = false) Byte categoryId) {

        List<Product> products;

        if (categoryId != null) {
            products = productRepository.findByCategoryId(categoryId);
        } else {
            products = productRepository.findAllWithCategory();
        }

        List<ProductDto> result = products
                .stream()
                .map(product -> productMapper.toDto(product))
                .toList();
        return result;

    }

}
