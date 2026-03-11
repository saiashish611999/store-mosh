package com.ashcode.store.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ashcode.store.dtos.products.ProductDto;
import com.ashcode.store.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Product product);

}
