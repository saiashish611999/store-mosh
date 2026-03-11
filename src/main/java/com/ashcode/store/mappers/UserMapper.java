package com.ashcode.store.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.ashcode.store.dtos.users.request.RegisterUserRequest;
import com.ashcode.store.dtos.users.request.UpdateUserRequest;
import com.ashcode.store.dtos.users.response.UserDto;
import com.ashcode.store.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(RegisterUserRequest request);

    void update(UpdateUserRequest request, @MappingTarget User user);

}
