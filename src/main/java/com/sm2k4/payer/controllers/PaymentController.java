package com.sm2k4.payer.controllers;

import com.sm2k4.payer.dtos.InitiatePaymentRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDTO requestDTO){
        return
    }
}
