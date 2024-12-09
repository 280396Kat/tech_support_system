package com.example.tech_support_system.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WaterFeedbackDto {

    private String userName;

    private String phoneNumber;

    private String email;

    private String description;

    private AttachedDto attachedDto;
}
