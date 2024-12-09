package com.example.tech_support_system.service.mail;

import com.example.tech_support_system.dto.UserDto;
import com.example.tech_support_system.event.UserRegisteredEvent;
import com.example.tech_support_system.service.UserEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEventPublisherImpl implements UserEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishUserRegisteredEvent(UserDto user) {
        applicationEventPublisher.publishEvent(new UserRegisteredEvent(this, user));
    }
}
