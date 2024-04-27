package com.sm2k4.payer.Gateways;


import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RazorPayGateway implements PaymentGateway{
    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    @Override
    public String generatePaymentLink(Long orderId, String email,String name, String phoneNumber) throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
        JSONObject paymentLinkRequest = new JSONObject();

        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("expire_by",System.currentTimeMillis() + 3600000);
        paymentLinkRequest.put("reference_id", orderId);
        paymentLinkRequest.put("description","Sample payment link for SST");
        JSONObject customer = new JSONObject();
        customer.put("name","+91"+phoneNumber);
        customer.put("contact",name);
        customer.put("email", email);
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        paymentLinkRequest.put("callback_url","https://www.google.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }
}
