package demo.rest;

import demo.domain.Payment;
import demo.domain.PaymentOrderResponse;
import demo.service.PaymentOrderResponseService;
import demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FoodPaymentOrderRestApi {

    private static final String PAYMENT_STATUS_SUCCESS = "Success";

    private PaymentService paymentService;  // PaymentServiceImpl injection
    private PaymentOrderResponseService paymentOrderResponseService;  // PaymentOrderResponseServiceImpl injection

    @Autowired
    public FoodPaymentOrderRestApi(PaymentService paymentService,
                                   PaymentOrderResponseService paymentOrderResponseService) {
        this.paymentService = paymentService;
        this.paymentOrderResponseService = paymentOrderResponseService;
    }

    /**
     * 1.  Receive paymentOrder from third-party-payment-service
     * 2.  Send paymentOrderResponse to food-order-service
     * 3.  Update PaymentInfo [MySQL]
     */
    @RequestMapping(value = "/api/payment", method = RequestMethod.PUT)
    public void paymentOrder(@RequestBody Payment paymentOrder) {
        log.info("Received PaymentOrder from 3rd-party-payment " + paymentOrder);

        // send msg to food-order-service
        if (paymentOrder.getPaymentStatus().equals(PAYMENT_STATUS_SUCCESS)) {
            PaymentOrderResponse paymentOrderResponse = paymentOrderResponseService.generatePaymentOrderResponse(paymentOrder);
            paymentOrderResponseService.sendPaymentOrderResponse(paymentOrderResponse);
        }

        // mark this paymentOrder as a completed payment
        paymentService.updatePaymentStatusById(paymentOrder.getPaymentStatus(),
                paymentOrder.getPaymentId());
    }


}
