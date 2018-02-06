package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Embeddable // this class can be embedded into another class: e.g: Payment class
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recipient {
    private String restaurantName;
    private String restaurantAddress;

}
