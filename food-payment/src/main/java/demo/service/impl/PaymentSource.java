package demo.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@EnableBinding(Source.class) // Bind MQ output channel with this class
@Slf4j  // for log
//@Component // for Hystrix
public class PaymentSource {

    @Autowired // Inject MQ output channel
    private MessageChannel output;

    // if sendMessageToOutputChannel() has error, then call sendMessageToOutputChannelFallback()
    //@HystrixCommand(fallbackMethod = "sendMessageToOutputChannelFallback")
    public String sendMessageToOutputChannel(Payment payment) {
        log.info("PaymentOrder @food-payment-service " + payment.toString());
        this.output.send(MessageBuilder.withPayload(payment).build()); // send message thru output channel
        return "Payment Pending";
    }

    // Plan B : backup fall back method
    public String sendMessageToOutputChannelFallback(Payment payment) {
        log.error("Hystrix Fallback Method. Unable to send message for RabbitMQ.");
        return "Resend PaymentInfo for PaymentOrder";
        // do it again.
        // can send a email to notify error info
    }

}
