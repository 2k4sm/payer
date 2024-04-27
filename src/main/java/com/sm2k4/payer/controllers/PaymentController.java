package com.sm2k4.payer.controllers;

import com.razorpay.RazorpayException;
import com.sm2k4.payer.dtos.InitiatePaymentRequestDTO;
import com.sm2k4.payer.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;


    PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/initiate")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDTO requestDto) throws RazorpayException {
        return paymentService.initiatePayment(requestDto.getOrderId(), requestDto.getEmail(),requestDto.getName(),requestDto.getPhoneNumber());
    }

}
