package com.example.tech_support_system.service.impl;

import com.example.tech_support_system.service.SenderService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SenderServiceImpl implements SenderService {
    @Override
    public Mono<Boolean> sendMassage(String email) {
        return null;
    }
}
