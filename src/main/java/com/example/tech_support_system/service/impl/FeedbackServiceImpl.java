package com.example.tech_support_system.service.impl;

import com.example.tech_support_system.dto.AttachedDto;
import com.example.tech_support_system.dto.FeedbackTickerNumberDto;
import com.example.tech_support_system.dto.WaterFeedbackDto;
import com.example.tech_support_system.entity.UserEntity;
import com.example.tech_support_system.entity.WaterFeedbackEntity;
import com.example.tech_support_system.service.AttachedService;
import com.example.tech_support_system.service.FeedbackService;
import com.example.tech_support_system.service.SenderService;
import com.example.tech_support_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final AttachedService attachedService;

    private final UserService userService;

    private final SenderService senderService;

    @Override
    public Mono<FeedbackTickerNumberDto> sendFeedback(WaterFeedbackDto waterFeedbackDto) {
        UserEntity userEntity = mapToEntity(waterFeedbackDto);
        return userService.createForUpdateUser(userEntity)
                .flatMap(user -> {
                    WaterFeedbackEntity waterFeedbackEntity = new WaterFeedbackEntity();
                    if (user != null) {
                        waterFeedbackEntity.setTicketNumber(1);
                        waterFeedbackEntity.setDescription(waterFeedbackDto.getDescription());
                        // дальше сохранить в БД
                        // взять почту
                    }
                    AttachedDto attachedDto = waterFeedbackDto.getAttachedDto();
                    if (attachedDto != null) {
                        attachedService.uploadFile(attachedDto);
                    }
                    FeedbackTickerNumberDto feedbackTickerNumberDto = new FeedbackTickerNumberDto();
                    feedbackTickerNumberDto.setNumber(waterFeedbackEntity.getTicketNumber());
                    return Mono.just(feedbackTickerNumberDto);
                }).switchIfEmpty(Mono.error(new IllegalArgumentException("Такого пользователя нет.")));
    }

    private UserEntity mapToEntity(WaterFeedbackDto waterFeedbackDto) {
        return UserEntity.builder()
                .userName(waterFeedbackDto.getUserName())
                .phoneNumber(waterFeedbackDto.getPhoneNumber())
                .email(waterFeedbackDto.getEmail())
                .build();
    }
}
