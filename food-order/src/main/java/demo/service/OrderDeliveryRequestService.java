package demo.service;

import demo.domain.Order;
import demo.domain.OrderDeliveryRequest;

public interface OrderDeliveryRequestService {
    OrderDeliveryRequest generateOrderDeliveryRequest(Order order);

    void sendOrderDeliveryRequest(OrderDeliveryRequest orderDeliveryRequest);
}
