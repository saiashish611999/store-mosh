package com.ashcode.store.mappers;

import org.mapstruct.Mapper;
import com.ashcode.store.dtos.UserDto;
import com.ashcode.store.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

}
