package demo.service.impl;

import demo.domain.Order;
import demo.domain.OrderDeliveryRequest;
import demo.service.OrderDeliveryRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class OrderDeliveryRequestServiceImpl implements OrderDeliveryRequestService {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public OrderDeliveryRequest generateOrderDeliveryRequest(Order order) {
        OrderDeliveryRequest orderDeliveryRequest = new OrderDeliveryRequest();
        orderDeliveryRequest.setId(order.getId());
        orderDeliveryRequest.setUser(order.getUser());
        orderDeliveryRequest.setRestaurant(order.getRestaurant());
        orderDeliveryRequest.setFoodItems(order.getFoodItems());

        return orderDeliveryRequest;
    }

    @Override
    public void sendOrderDeliveryRequest(OrderDeliveryRequest orderDeliveryRequest) {
        log.info("OrderDeliveryRequest @food-order " + orderDeliveryRequest);
        String foodPayment = "http://localhost:9003";
        this.restTemplate.postForLocation(foodPayment + "/api/delivery", orderDeliveryRequest);
    }
}
