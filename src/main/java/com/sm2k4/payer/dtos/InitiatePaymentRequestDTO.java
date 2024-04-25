package com.sm2k4.payer.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentRequestDTO {
    private long orderId;
    private String email;
}
