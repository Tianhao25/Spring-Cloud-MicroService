package demo.rest;

import demo.domain.InitRestaurants;
import demo.domain.MenuItem;
import demo.domain.Order;
import demo.service.OrderService;
import demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class FoodOrderRestController {

    private RestaurantService restaurantService;
    private OrderService orderService;

    @Autowired
    public FoodOrderRestController(RestaurantService restaurantService, OrderService orderService) {
        this.restaurantService = restaurantService;
        this.orderService = orderService;
    }

    @RequestMapping("/restaurants")
    public InitRestaurants initial() throws IOException {
        return restaurantService.loadInitRestaurants();
    }

    // localhost:9000/restaurants/Elyse Restaurant
    @RequestMapping(value = "/restaurants/{restaurantName}", method = RequestMethod.GET)
    public List<MenuItem> findMenuItemsByRestaurantName(@PathVariable String restaurantName) throws IOException {
        InitRestaurants initRestaurants = restaurantService.loadInitRestaurants();
        return restaurantService.findMenuItemsByRestaurantName(restaurantName, initRestaurants);
    }

    // localhost:9000/order
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Order upload(@RequestBody Order order) { // order-request.json
        Order newOrder = orderService.calculateTotalPriceofOrder(order);
        return orderService.saveOrder(newOrder);
    }


}
