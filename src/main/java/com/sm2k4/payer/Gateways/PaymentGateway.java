package com.sm2k4.payer.Gateways;

import com.razorpay.RazorpayException;


public interface PaymentGateway {
    public String generatePaymentLink(Long orderId, String email,String name,String phoneNumber) throws RazorpayException;
}
