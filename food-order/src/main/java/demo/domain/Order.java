package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Document
public class Order {

    @Id
    private String id;

    private User user;
    private Restaurant restaurant;
    private List<MenuItem> foodItems = new ArrayList<>(0);
    private Date timestamp = new Date();
    private String orderStatus = "Pending";

    private Double subTotal;
    private Double tax;
    private Double total;

}
