package demo.service;

import demo.domain.Payment;
import demo.domain.Sender;

public interface PaymentService {
    Sender findBySenderUsername(String userName);

    Payment savePaymentOrder(Payment payment);

    Payment updatePaymentStatusById(String paymentStatus, Long paymentId);
}
