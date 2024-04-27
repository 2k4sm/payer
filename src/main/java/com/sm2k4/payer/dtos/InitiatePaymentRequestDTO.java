package com.sm2k4.payer.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentRequestDTO {
    private Long orderId;
    private String email;
    private String name;
    private String phoneNumber;
}
