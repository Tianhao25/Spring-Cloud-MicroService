package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Date;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    private String orderId;
    private Date orderTimestamp = new Date();
}
