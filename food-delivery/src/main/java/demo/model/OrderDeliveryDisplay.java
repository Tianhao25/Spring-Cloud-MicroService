package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"id", "estimatedDeliveryTime"})
public class OrderDeliveryDisplay {
    private String id;
    private Integer estimatedDeliveryTime; // min
    private String userName;
    private String RestaurantName;
    private Integer NumberOfFoodItems;
}
