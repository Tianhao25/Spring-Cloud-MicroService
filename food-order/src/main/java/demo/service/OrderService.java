package demo.service;

import demo.domain.Order;
import demo.domain.PaymentOrderResponse;

import java.util.List;


public interface OrderService {
    Order calculateTotalPriceofOrder(Order order);

    Order saveOrder(Order order);

    Order findOrder(PaymentOrderResponse paymentOrderResponse);

    List<Order> findAllOrders();
}
