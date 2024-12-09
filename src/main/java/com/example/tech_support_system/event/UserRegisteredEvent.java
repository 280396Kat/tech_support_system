package com.example.tech_support_system.event;

import com.example.tech_support_system.dto.UserDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Getter
public class UserRegisteredEvent extends ApplicationEvent {


    private final UserDto user;
    public UserRegisteredEvent(Object source, UserDto user) {
        super(source);
        this.user = user;
    }

}
