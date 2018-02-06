package demo.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)  // for json serialization & deserialization
@JsonPropertyOrder({"numberofRestaurants", "restaurants"})
public class InitRestaurants { // initial restaurants
    private List<Restaurant> restaurants = new ArrayList<>(0);

    public int getNumberofRestaurants() {
        return restaurants.size();
    }

}
