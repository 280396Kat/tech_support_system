package com.example.tech_support_system.service;

import reactor.core.publisher.Mono;

public interface SenderService {

    Mono<Boolean> sendMassage(String email);
}
