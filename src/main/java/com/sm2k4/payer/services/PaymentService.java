package com.sm2k4.payer.services;

import com.razorpay.RazorpayException;
import com.sm2k4.payer.Gateways.PaymentGateway;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {

    private final PaymentGateway paymentGateway;

    PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String initiatePayment(Long orderId, String email,String name,String phoneNumber) throws RazorpayException {
        return paymentGateway.generatePaymentLink(orderId, email,name,phoneNumber);
    }
}