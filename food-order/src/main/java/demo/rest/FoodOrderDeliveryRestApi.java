package demo.rest;

import demo.domain.Order;
import demo.domain.OrderDeliveryRequest;
import demo.domain.PaymentOrderResponse;
import demo.service.OrderDeliveryRequestService;
import demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class FoodOrderDeliveryRestApi {

    private OrderService orderService;
    private OrderDeliveryRequestService orderDeliveryRequestService;

    @Autowired
    public FoodOrderDeliveryRestApi(OrderService orderService,
                                    OrderDeliveryRequestService orderDeliveryRequestService) {
        this.orderService = orderService;
        this.orderDeliveryRequestService = orderDeliveryRequestService;
    }

    /**
     * when order is paid successful, this api will be called
     * 1. Received PaymentOrderResponse from food-payment-service
     * 2. Find completed order in MongoDB
     * 3. Generate OrderDeliveryRequest & send to food-delivery-service
     */
    @RequestMapping(value = "/api/order", method = RequestMethod.PUT)
    public void paymentOrder(@RequestBody PaymentOrderResponse paymentOrderResponse) {
        log.info("Received paymentOrderResponse @food-order-service " + paymentOrderResponse);

        // find order in MongoDB & send to delivery service
        Order orderCompleted = orderService.findOrder(paymentOrderResponse);
        OrderDeliveryRequest orderDeliveryRequest = orderDeliveryRequestService.generateOrderDeliveryRequest(orderCompleted);
        orderDeliveryRequestService.sendOrderDeliveryRequest(orderDeliveryRequest);
    }

    // localhost:9000/orders
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> findOrders() {
        orderService.findAllOrders();
        return orderService.findAllOrders();
    }
}
