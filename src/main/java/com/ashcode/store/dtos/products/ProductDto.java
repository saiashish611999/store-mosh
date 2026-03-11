package com.ashcode.store.dtos.products;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {

    Long id;

    String name;

    BigDecimal price;

    String description;

    Byte categoryId;

}
