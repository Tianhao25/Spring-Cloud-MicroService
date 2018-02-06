package demo.service.impl;

import demo.domain.MenuItem;
import demo.domain.Order;
import demo.domain.OrderRepository;
import demo.domain.PaymentOrderResponse;
import demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private static final Double TAX_RATE = 0.0925;  // Tax rate in CA

    @Autowired  // inject OrderRepositoryImpl
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order calculateTotalPriceofOrder(Order order) {
        order.setSubTotal(calculateSubTotal(order));
        order.setTax(doubleFormat(order.getSubTotal() * TAX_RATE));
        order.setTotal(order.getSubTotal() + order.getTax());

        return order;
    }

    private Double calculateSubTotal(Order order) {
        Double subTotal = 0.0;

        for (MenuItem foodItem : order.getFoodItems()) {
            subTotal += foodItem.getPrice() * foodItem.getQuantity();
        }

        return subTotal;
    }

    // Keep two decimal places and round half up for tax
    private Double doubleFormat(Double num) {
        BigDecimal bigDecimal = new BigDecimal(num);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    @Override
    public Order saveOrder(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public Order findOrder(PaymentOrderResponse paymentOrderResponse) {
        return orderRepository.findById(paymentOrderResponse.getOrderId());
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
}
