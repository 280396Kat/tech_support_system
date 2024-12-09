package com.example.tech_support_system.event;

import com.example.tech_support_system.dto.UserDto;
import com.example.tech_support_system.service.MessageSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRegisteredEventListener {

    private final MessageSenderService messageSenderService;

    @EventListener
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        UserDto user = event.getUser();
        String mail = user.getEmail();
        messageSenderService.sendMessage(mail);
    }
}
