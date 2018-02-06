package demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.domain.InitRestaurants;
import demo.domain.MenuItem;
import demo.domain.Restaurant;
import demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private ObjectMapper objectMapper;  // Json string to java object

    @Override
    public InitRestaurants loadInitRestaurants() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/init-restaurants.json");
        return objectMapper.readValue(inputStream, InitRestaurants.class);
    }

    @Override
    public List<MenuItem> findMenuItemsByRestaurantName(String RestaurantName, InitRestaurants initRestaurants) {
        List<MenuItem> menuItems = new ArrayList<>();

        for (Restaurant restaurant : initRestaurants.getRestaurants()) {
            if (restaurant.getName().equals(RestaurantName)) {
                menuItems.addAll(restaurant.getMenuItems());
            }
        }

        return menuItems;
    }
}
