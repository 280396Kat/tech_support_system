package com.example.tech_support_system.service;

import com.example.tech_support_system.dto.UserDto;
import com.example.tech_support_system.entity.UserEntity;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<UserDto> createForUpdateUser(UserEntity userEntity);

    Mono<UserDto> getUserInfoByUserName(String userName);

    Mono<UserDto> save(UserEntity userEntity);

    Mono<UserDto> update(UserEntity userEntity);
}
