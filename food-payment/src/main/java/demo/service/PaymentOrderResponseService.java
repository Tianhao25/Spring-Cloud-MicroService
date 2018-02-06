package demo.service;

import demo.domain.Payment;
import demo.domain.PaymentOrderResponse;

public interface PaymentOrderResponseService {
    PaymentOrderResponse generatePaymentOrderResponse(Payment paymentOrder);

    void sendPaymentOrderResponse(PaymentOrderResponse paymentOrderResponse);
}
