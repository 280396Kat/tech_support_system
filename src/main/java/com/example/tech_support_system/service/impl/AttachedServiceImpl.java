package com.example.tech_support_system.service.impl;

import com.example.tech_support_system.dto.AttachedDto;
import com.example.tech_support_system.service.AttachedService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AttachedServiceImpl implements AttachedService {

    @Override
    public Mono<Void> uploadFile(AttachedDto attachedDto) {
        return null;
    }
}
