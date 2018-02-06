package demo.rest;

import demo.domain.Payment;
import demo.domain.Sender;
import demo.service.PaymentService;
import demo.service.impl.PaymentSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j  // for log
public class FoodPaymentRestController {

    private PaymentService paymentService;  // paymentServiceImpl injection
    private PaymentSource paymentSource;   // MQ Source

    @Autowired
    public FoodPaymentRestController(PaymentService paymentService, PaymentSource paymentSource) {
        this.paymentService = paymentService;
        this.paymentSource = paymentSource;
    }

    // localhost:9001/payment/Angela   
    @RequestMapping(value = "/payment/{userName}", method = RequestMethod.GET) // find using get method
    public Sender findSenderInfo(@PathVariable String userName) {
        return paymentService.findBySenderUsername(userName);
    }

    // localhost:9001/payment
    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String savePaymentOrder(@RequestBody Payment payment) { // submit paymentOrder, payment-request.json
        Payment paymentOrder = paymentService.savePaymentOrder(payment);
        return paymentSource.sendMessageToOutputChannel(paymentOrder);
        //return paymentService.updatePaymentStatusById("pending", paymentOrder.getPaymentId());
    }

}