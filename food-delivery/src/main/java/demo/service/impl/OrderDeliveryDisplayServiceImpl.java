package demo.service.impl;

import demo.model.OrderDeliveryDisplay;
import demo.model.OrderDeliveryRequest;
import demo.service.OrderDeliveryDisplayService;
import org.springframework.stereotype.Service;

@Service
public class OrderDeliveryDisplayServiceImpl implements OrderDeliveryDisplayService {
    @Override
    public OrderDeliveryDisplay generateOrderDeliveryDisplay(OrderDeliveryRequest orderDeliveryRequest) {
        OrderDeliveryDisplay orderDeliveryDisplay = new OrderDeliveryDisplay();
        orderDeliveryDisplay.setId(orderDeliveryRequest.getId());
        orderDeliveryDisplay.setUserName(orderDeliveryRequest.getUser().getUserName());
        orderDeliveryDisplay.setRestaurantName(orderDeliveryRequest.getRestaurant().getName());
        orderDeliveryDisplay.setNumberOfFoodItems(orderDeliveryRequest.getFoodItems().size());

        return orderDeliveryDisplay;
    }

    @Override
    public OrderDeliveryDisplay calculateEstimateDeliveryTime(OrderDeliveryDisplay orderDeliveryDisplay) {
        int min = 20;
        int max = 60;
        int estimateDeliveryTime = min + (int) (Math.random() * (max - min + 1));
        orderDeliveryDisplay.setEstimatedDeliveryTime(estimateDeliveryTime);

        return orderDeliveryDisplay;
    }

}
