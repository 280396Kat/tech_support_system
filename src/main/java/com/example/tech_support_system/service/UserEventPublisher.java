package com.example.tech_support_system.service;

import com.example.tech_support_system.dto.UserDto;

public interface UserEventPublisher {

    void publishUserRegisteredEvent(UserDto user);
}
