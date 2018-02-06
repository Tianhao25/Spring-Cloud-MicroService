package demo.service;

import demo.model.OrderDeliveryDisplay;
import demo.model.OrderDeliveryRequest;

public interface OrderDeliveryDisplayService {

    OrderDeliveryDisplay generateOrderDeliveryDisplay(OrderDeliveryRequest orderDeliveryRequest);

    OrderDeliveryDisplay calculateEstimateDeliveryTime(OrderDeliveryDisplay orderDeliveryDisplay);

}
