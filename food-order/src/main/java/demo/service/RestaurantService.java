package demo.service;

import demo.domain.InitRestaurants;
import demo.domain.MenuItem;

import java.io.IOException;
import java.util.List;

public interface RestaurantService {
    InitRestaurants loadInitRestaurants() throws IOException;

    List<MenuItem> findMenuItemsByRestaurantName(String RestaurantName, InitRestaurants initRestaurants);
}
