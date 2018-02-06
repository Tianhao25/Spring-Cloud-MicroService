package demo.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Sender {
    private String userName;
    private String phoneNumber;
    private String creditCardNumber;
    private String expirationDate;
    private String securityCode;
}
