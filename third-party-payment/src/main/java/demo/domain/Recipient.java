package demo.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Recipient {
    private String restaurantName;
    private String restaurantAddress;

}
