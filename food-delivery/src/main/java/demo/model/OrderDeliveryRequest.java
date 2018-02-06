package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"id", "estimatedDeliveryTime"})
public class OrderDeliveryRequest {
    private String id;

    private User user;
    private Restaurant restaurant;
    private List<MenuItem> foodItems = new ArrayList<>(0);

    private Integer estimatedDeliveryTime; // min
}
