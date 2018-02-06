package demo.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)  // default constructor
public class User {
    private String userName;
    private String email;
    private String phoneNumber;
    private String deliveryAddress;
}
