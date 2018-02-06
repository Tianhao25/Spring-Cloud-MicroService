package demo.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonPropertyOrder({"name", "menuItems"})
public class Restaurant {  // restaurant & its menu Items
    private String name;
    private String address;

    private List<MenuItem> menuItems = new ArrayList<>(0);

}
