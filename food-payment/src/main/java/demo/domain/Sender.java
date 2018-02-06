package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sender {
    private String userName;
    private String phoneNumber;
    private String creditCardNumber;
    private String expirationDate;
    private String securityCode;

}
