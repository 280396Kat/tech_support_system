package com.example.tech_support_system.service;

import com.example.tech_support_system.dto.FeedbackTickerNumberDto;
import com.example.tech_support_system.dto.WaterFeedbackDto;
import reactor.core.publisher.Mono;

public interface FeedbackService {

    Mono<FeedbackTickerNumberDto> sendFeedback(WaterFeedbackDto waterFeedbackDto);
}
