package com.example.tech_support_system.service.impl;

import com.example.tech_support_system.dto.UserDto;
import com.example.tech_support_system.entity.UserEntity;
import com.example.tech_support_system.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public Mono<UserDto> createForUpdateUser(UserEntity userEntity) {
        return getUserInfoByUserName(userEntity.getUserName())
                .flatMap(user -> {
                    if(user == null) {
                        return save(userEntity);
                    } else if (user != null && !userEntity.getEmail().equals(user.getEmail())) {
                        return update(userEntity);
                    } else {
                        return Mono.just(user);
                    }
                });
    }

    @Override
    public Mono<UserDto> getUserInfoByUserName(String userName) {
        return null;
    }

    @Override
    public Mono<UserDto> save(UserEntity userEntity) {
        return null;
    }

    @Override
    public Mono<UserDto> update(UserEntity userEntity) {
        return null;
    }
}
