package com.example.tech_support_system.service;

import com.example.tech_support_system.dto.AttachedDto;
import reactor.core.publisher.Mono;

public interface AttachedService {

    Mono<Void> uploadFile(AttachedDto attachedDto);
}
