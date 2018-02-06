package demo.service.impl;

import demo.domain.Payment;
import demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Send result of processPaymentOrder to Food-Payment-Service
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    private static final String PAYMENT_STATUS_SUCCESS = "Success";

    private RestTemplate restTemplate = new RestTemplate();

    // spring dependency injection. Defined in application.yml
    @Value("${com.angela.food.payment}")
    private String foodPayment;

    @Override
    public void processPaymentOrder(Payment payment) {
        payment.setPaymentStatus(PAYMENT_STATUS_SUCCESS);

        // send updated paymentStatus to food-payment-service
        log.info("update paymentOrder status @3rd-party-payment " + payment);
        this.restTemplate.put(foodPayment + "/api/payment", payment);
    }
}
